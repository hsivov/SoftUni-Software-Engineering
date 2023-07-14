package bg.softuni.dtoExercise;

import bg.softuni.dtoExercise.model.dto.GameAddDto;
import bg.softuni.dtoExercise.model.dto.UserLoginDto;
import bg.softuni.dtoExercise.model.dto.UserRegisterDto;
import bg.softuni.dtoExercise.service.GameService;
import bg.softuni.dtoExercise.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final BufferedReader bufferedReader;
    private final UserService userService;
    private final GameService gameService;

    public CommandLineRunnerImpl(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {

        while (true) {

        System.out.println("Enter command: ");
        String[] commands = bufferedReader.readLine().split("\\|");

            switch (commands[0]) {
                case "RegisterUser" -> userService
                        .registerUser(new UserRegisterDto(commands[1], commands[2], commands[3], commands[4]));

                case "LoginUser" -> userService
                        .loginUser(new UserLoginDto(commands[1], commands[2]));
                case "Logout" -> userService
                        .logout();
                case "AddGame" -> gameService
                        .addGame(new GameAddDto(commands[1], new BigDecimal(commands[2]), Double.parseDouble(commands[3]),
                                commands[4], commands[5], commands[6], commands[7]));
                case "EditGame" -> gameService
                        .editGame(Long.parseLong(commands[1]),
                                new BigDecimal(commands[2].split("=")[1]),
                                Double.parseDouble(commands[3].split("=")[1]));

                case "DeleteGame" -> gameService
                        .deleteGame(Long.parseLong(commands[1]));

                case "AllGames" -> gameService
                        .getAllGames();
            }
        }
    }
}
