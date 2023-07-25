package exam.softuni.instagraphlite.service.impl;

import com.google.gson.Gson;
import exam.softuni.instagraphlite.models.dto.UserSeedDto;
import exam.softuni.instagraphlite.models.entity.Picture;
import exam.softuni.instagraphlite.models.entity.User;
import exam.softuni.instagraphlite.repository.UserRepository;
import exam.softuni.instagraphlite.service.PictureService;
import exam.softuni.instagraphlite.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import exam.softuni.instagraphlite.service.UserService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER_FILE_PATH = "src/main/resources/files/users.json";

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final PictureService pictureService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, PictureService pictureService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.pictureService = pictureService;
    }

    @Override
    public boolean areImported() {
        return userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(USER_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {
        StringBuilder sb = new StringBuilder();

        UserSeedDto[] userSeedDtos = gson.fromJson(readFromFileContent(), UserSeedDto[].class);

        Arrays.stream(userSeedDtos)
                .filter(userSeedDto -> {
                    boolean isValid = validationUtil.isValid(userSeedDto);

                    Optional<User> byUsername = userRepository.findFirstByUsername(userSeedDto.getUsername());
                    Picture byPicturePath = pictureService.getPictureByPath(userSeedDto.getProfilePicture());

                    if (byUsername.isPresent() || byPicturePath == null) {
                        isValid = false;
                    }
                    sb
                            .append(isValid ? String.format("Successfully imported User: %s",
                                    userSeedDto.getUsername())
                                    : "Invalid User")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(userSeedDto -> {
                    User user = modelMapper.map(userSeedDto, User.class);
                    Picture picture = pictureService.getPictureByPath(userSeedDto.getProfilePicture());

                    user.setPicture(picture);

                    return user;
                })
                .forEach(userRepository::save);

        return sb.toString();
    }

    @Override
    public User getUserByUserName(String username) {
        return userRepository.findFirstByUsername(username).orElse(null);
    }

    @Override
    public String exportUsersWithTheirPosts() {

        return null;
    }
}
