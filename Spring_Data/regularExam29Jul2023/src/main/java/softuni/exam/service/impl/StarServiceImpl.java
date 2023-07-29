package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.StarSeedDto;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;

@Service
public class StarServiceImpl implements StarService {
    private static final String STARS_FILE_PATH = "src/main/resources/files/json/stars.json";
    private final StarRepository starRepository;
    private final ConstellationRepository constellationRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public StarServiceImpl(StarRepository starRepository, ConstellationRepository constellationRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.starRepository = starRepository;
        this.constellationRepository = constellationRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return starRepository.count() > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(Path.of(STARS_FILE_PATH));
    }

    @Override
    public String importStars() throws IOException {
        StringBuilder sb = new StringBuilder();

        StarSeedDto[] starSeedDtos = gson.fromJson(readStarsFileContent(), StarSeedDto[].class);

        Arrays.stream(starSeedDtos)
                .filter(starSeedDto -> {
                    boolean isValid = validationUtil.isValid(starSeedDto);

                    Optional<Star> byName = starRepository.findFirstByName(starSeedDto.getName());
                    if (byName.isPresent()) {
                        isValid = false;
                    }

                    sb
                            .append(isValid ? String.format(Locale.US,"Successfully imported star %s - %.2f light years",
                                    starSeedDto.getName(),
                                    starSeedDto.getLightYears())
                                    : "Invalid star")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(starSeedDto -> {
                    Star star = modelMapper.map(starSeedDto, Star.class);

                    star.setConstellation(constellationRepository.findFirstById(starSeedDto.getConstellation()));

                    return star;
                })
                .forEach(starRepository::save);

        return sb.toString();
    }

    @Override
    public String exportStars() {
        return null;
    }
}
