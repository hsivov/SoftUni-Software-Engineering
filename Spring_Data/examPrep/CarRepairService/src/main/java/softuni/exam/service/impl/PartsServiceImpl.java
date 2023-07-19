package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PartSeedDto;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.PartsRepository;
import softuni.exam.service.PartsService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class PartsServiceImpl implements PartsService {
    private static final String PARTS_FILE_PATH = "src/main/resources/files/json/parts.json";
    private final PartsRepository partsRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public PartsServiceImpl(PartsRepository partsRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.partsRepository = partsRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return partsRepository.count() > 0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return Files.readString(Path.of(PARTS_FILE_PATH));
    }

    @Override
    public String importParts() throws IOException {
        StringBuilder sb = new StringBuilder();

        PartSeedDto[] partSeedDtos = gson.fromJson(readPartsFileContent(), PartSeedDto[].class);

        Arrays.stream(partSeedDtos)
                .filter(partSeedDto -> {
                    boolean isValid = validationUtil.isValid(partSeedDto);

                    Optional<Part> partByName = partsRepository.findFirstByPartName(partSeedDto.getPartName());
                    if (partByName.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported part %s - %s",
                            partSeedDto.getPartName(),
                            partSeedDto.getPrice())
                            : "Invalid part")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(partSeedDto -> modelMapper.map(partSeedDto, Part.class))
                .forEach(partsRepository::save);

        return sb.toString();
    }

    @Override
    public Part getPartById(Long partId) {
        return partsRepository.findById(partId).orElse(null);
    }
}
