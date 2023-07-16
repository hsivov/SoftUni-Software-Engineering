package exam.service.impl;

import exam.model.dto.ShopSeedRootDto;
import exam.model.entity.Shop;
import exam.model.entity.Town;
import exam.repository.ShopRepository;
import exam.service.ShopService;
import exam.service.TownService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {
    private static final String SHOPS_FILE_PATH = "src/main/resources/files/xml/shops.xml";
    private final ShopRepository shopRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final TownService townService;

    public ShopServiceImpl(ShopRepository shopRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil, TownService townService) {
        this.shopRepository = shopRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(SHOPS_FILE_PATH));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(SHOPS_FILE_PATH, ShopSeedRootDto.class)
                .getShops()
                .stream()
                .filter(shopSeedDto -> {
                    boolean isValid = validationUtil.isValid(shopSeedDto);

                    Optional<Shop> byName = shopRepository.findByName(shopSeedDto.getName());
                    if (byName.isPresent()) {
                        isValid = false;
                    }

                    sb
                            .append(isValid ? String.format("Successfully imported Shop %s - %.0f",
                                    shopSeedDto.getName(),
                                    shopSeedDto.getIncome())
                                    : "Invalid shop")
                            .append(System.lineSeparator());

                    return  isValid;
                })
                .map(shopSeedDto -> {
                    Shop shop = modelMapper.map(shopSeedDto, Shop.class);

                    Town town = townService.getTownByName(shopSeedDto.getTown().getName());
                    shop.setTown(town);
                    return shop;
                })
                .forEach(shopRepository::save);

        return sb.toString();
    }

    @Override
    public Shop getShopByName(String name){
        return shopRepository.findByName(name).orElse(null);
    }
}
