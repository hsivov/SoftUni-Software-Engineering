package com.example.football.service.impl;

import com.example.football.models.dto.PlayerSeedRootDto;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static final String PLAYERS_FILE_PATH = "src/main/resources/files/xml/players.xml";
    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final TeamService teamService;
    private final TownService townService;
    private final StatService statService;

    public PlayerServiceImpl(PlayerRepository playerRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil, TeamService teamService, TownService townService, StatService statService) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.teamService = teamService;
        this.townService = townService;
        this.statService = statService;
    }

    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException {
        StringBuilder sb = new StringBuilder();
        xmlParser.fromFile(PLAYERS_FILE_PATH, PlayerSeedRootDto.class)
                .getPlayerSeedDtos()
                .stream()
                .filter(playerSeedDto -> {
                    boolean isValid = validationUtil.isValid(playerSeedDto);

                    Optional<Player> playerByEmail = playerRepository.findPlayerByEmail(playerSeedDto.getEmail());
                    if (playerByEmail.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported Player %s %s - %s",
                            playerSeedDto.getFirstName(),
                            playerSeedDto.getLastName(),
                            playerSeedDto.getPosition())
                            : "Invalid player")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(playerSeedDto -> {
                    Player player = modelMapper.map(playerSeedDto, Player.class);

                    Team team = teamService.getTeamByName(playerSeedDto.getTeam().getName());
                    Town town = townService.getTownByName(playerSeedDto.getTown().getName());
                    Stat stat = statService.getStatById(playerSeedDto.getStat().getId());

                    player.setTeam(team);
                    player.setTown(town);
                    player.setStat(stat);

                    return player;
                })
                .forEach(playerRepository::save);

        return sb.toString();
    }

    @Override
    public String exportBestPlayers() {
        StringBuilder sb = new StringBuilder();

        playerRepository
                .findPlayerByBirthDateAfterAndBirthDateBeforeOrderByStat_ShootingDescStat_PassingDescStat_EnduranceDescLastName(
                        LocalDate.parse("01-01-1995", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        LocalDate.parse("01-01-2003", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
                .forEach(player -> {
                    sb
                            .append(String.format("Player - %s %s\n" +
                                    "    Position - %s\n" +
                                    "    Team - %s\n" +
                                    "    Stadium - %s\n",
                                    player.getFirstName(),
                                    player.getLastName(),
                                    player.getPosition(),
                                    player.getTeam().getName(),
                                    player.getTeam().getStadiumName()))
                            .append(System.lineSeparator());
                });

        return sb.toString();
    }
}
