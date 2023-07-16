package com.example.football.service.impl;

import com.example.football.models.dto.StatSeedRootDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class StatServiceImpl implements StatService {
    private static final String STATS_FILE_PATH = "src/main/resources/files/xml/stats.xml";
    private final StatRepository statRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    public StatServiceImpl(StatRepository statRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.statRepository = statRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }


    @Override
    public boolean areImported() {
        return statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(STATS_FILE_PATH));
    }

    @Override
    public String importStats() throws JAXBException {
        StringBuilder sb = new StringBuilder();
        StatSeedRootDto statSeedRootDto = xmlParser.fromFile(STATS_FILE_PATH, StatSeedRootDto.class);

        statSeedRootDto.getStats()
                .stream()
                .filter(statSeedDto -> {
                    boolean isValid = validationUtil.isValid(statSeedDto);

                    Optional<Stat> stat = statRepository.findByPassingAndShootingAndEndurance(
                            statSeedDto.getPassing(), statSeedDto.getShooting(), statSeedDto.getEndurance()
                    );
                    if (stat.isPresent()) {
                        isValid = false;
                    }

                    sb
                            .append(isValid ? String.format("Successfully imported Stat %.2f - %.2f - %.2f",
                                    statSeedDto.getPassing(),
                                    statSeedDto.getShooting(),
                                    statSeedDto.getEndurance())
                                    : "Invalid stat")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(statSeedDto -> modelMapper.map(statSeedDto, Stat.class))
                .forEach(statRepository::save);

        return sb.toString();
    }

    @Override
    public Stat getStatById(Long statId) {
        return statRepository.findById(statId).orElse(null);
    }
}
