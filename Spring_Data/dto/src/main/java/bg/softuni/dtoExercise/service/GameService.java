package bg.softuni.dtoExercise.service;

import bg.softuni.dtoExercise.model.dto.GameAddDto;

import java.math.BigDecimal;

public interface GameService {
    void addGame(GameAddDto gameAddDto);

    void editGame(Long gameId, BigDecimal price, Double size);

    void deleteGame(long gameId);

    void getAllGames();
}
