package bg.softuni.dtoExercise.service;

import bg.softuni.dtoExercise.model.dto.GameAddDto;
import bg.softuni.dtoExercise.model.entity.Game;
import bg.softuni.dtoExercise.repository.GameRepository;
import bg.softuni.dtoExercise.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {

        Set<ConstraintViolation<GameAddDto>> violations = validationUtil.violations(gameAddDto);

        if (!violations.isEmpty()) {
            violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        Game game = modelMapper.map(gameAddDto, Game.class);
        game.setReleasedDate(LocalDate.parse(gameAddDto.getReleaseDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        gameRepository.save(game);
        System.out.println("Added " + game.getTitle());
    }

    @Override
    public void editGame(Long gameId, BigDecimal price, Double size) {
        Game game = gameRepository.findById(gameId)
                .orElse(null);

        if (game == null) {
            System.out.println("Game doesn't exist");
            return;
        }

        game.setPrice(price);
        game.setSize(size);

        gameRepository.save(game);
    }

    @Override
    public void deleteGame(long gameId) {
        gameRepository.deleteById(gameId);
    }

    @Override
    public void getAllGames() {
        gameRepository.findAll()
                .stream()
                .map(game -> String.format("%s %.2f", game.getTitle(), game.getPrice()))
                .forEach(System.out::println);
    }
}
