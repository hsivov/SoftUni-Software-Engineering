package exam.softuni.instagraphlite.service;

import exam.softuni.instagraphlite.models.entity.User;

import java.io.IOException;

public interface UserService {
    boolean areImported();
    String readFromFileContent() throws IOException;
    String importUsers() throws IOException;

    User getUserByUserName(String username);

    String exportUsersWithTheirPosts();
}
