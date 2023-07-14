package bg.softuni.dtoExercise.service;

import bg.softuni.dtoExercise.model.dto.UserLoginDto;
import bg.softuni.dtoExercise.model.dto.UserRegisterDto;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logout();
}
