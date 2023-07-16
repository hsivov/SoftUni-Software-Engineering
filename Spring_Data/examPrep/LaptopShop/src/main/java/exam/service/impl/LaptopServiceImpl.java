package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.LaptopSeedDto;
import exam.model.entity.Laptop;
import exam.model.entity.Shop;
import exam.repository.LaptopRepository;
import exam.service.LaptopService;
import exam.service.ShopService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class LaptopServiceImpl implements LaptopService {
    private static final String LAPTOPS_FILE_PATH = "src/main/resources/files/json/laptops.json";
    private final LaptopRepository laptopRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ShopService shopService;

    public LaptopServiceImpl(LaptopRepository laptopRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, ShopService shopService) {
        this.laptopRepository = laptopRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.shopService = shopService;
    }

    @Override
    public boolean areImported() {
        return laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(Path.of(LAPTOPS_FILE_PATH));
    }

    @Override
    public String importLaptops() throws IOException {
        StringBuilder sb = new StringBuilder();

        LaptopSeedDto[] laptopSeedDtos = gson.fromJson(readLaptopsFileContent(), LaptopSeedDto[].class);
        Arrays.stream(laptopSeedDtos)
                .filter(laptopSeedDto -> {
                    boolean isValid = validationUtil.isValid(laptopSeedDto);

                    Optional<Laptop> byMacAddress = laptopRepository.findLaptopByMacAddress(laptopSeedDto.getMacAddress());
                    if (byMacAddress.isPresent()) {
                        isValid = false;
                    }

                    sb
                            .append(isValid ? String.format("Successfully imported Laptop %s - %.2f - %d - %d",
                                    laptopSeedDto.getMacAddress(),
                                    laptopSeedDto.getCpuSpeed(),
                                    laptopSeedDto.getRam(),
                                    laptopSeedDto.getStorage())
                                    : "Invalid Laptop")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(laptopSeedDto -> {
                    Laptop laptop = modelMapper.map(laptopSeedDto, Laptop.class);

                    Shop shop = shopService.getShopByName(laptopSeedDto.getShop().getName());
                    laptop.setShop(shop);
                    return laptop;
                })
                .forEach(laptopRepository::save);

        return sb.toString();
    }

    @Override
    public String exportBestLaptops() {
        StringBuilder sb = new StringBuilder();

        laptopRepository.findAllByOrderByCpuSpeedDescRamDescStorageDescMacAddress()
                .forEach(laptop -> {
                    sb
                            .append(String.format("Laptop - %s\n" +
                                    "*Cpu speed - %.2f\n" +
                                    "**Ram - %d\n" +
                                    "***Storage - %d\n" +
                                    "****Price - %.2f\n" +
                                    "#Shop name - %s\n" +
                                    "##Town - %s\n",
                                    laptop.getMacAddress(),
                                    laptop.getCpuSpeed(),
                                    laptop.getRam(),
                                    laptop.getStorage(),
                                    laptop.getPrice(),
                                    laptop.getShop().getName(),
                                    laptop.getShop().getTown().getName()))
                            .append(System.lineSeparator());
                });
        return sb.toString();
    }
}
