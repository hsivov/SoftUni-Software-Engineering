package exam.softuni.instagraphlite.service.impl;

import exam.softuni.instagraphlite.models.dto.PostSeedRootDto;
import exam.softuni.instagraphlite.models.entity.Picture;
import exam.softuni.instagraphlite.models.entity.Post;
import exam.softuni.instagraphlite.models.entity.User;
import exam.softuni.instagraphlite.repository.PostRepository;
import exam.softuni.instagraphlite.service.PictureService;
import exam.softuni.instagraphlite.service.PostService;
import exam.softuni.instagraphlite.service.UserService;
import exam.softuni.instagraphlite.util.ValidationUtil;
import exam.softuni.instagraphlite.util.XmlParser;
import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private static final String POSTS_FILE_PATH = "src/main/resources/files/posts.xml";
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private final PictureService pictureService;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil, UserService userService, PictureService pictureService) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.pictureService = pictureService;
    }

    @Override
    public boolean areImported() {
        return postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(POSTS_FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(POSTS_FILE_PATH, PostSeedRootDto.class)
                .getPosts()
                .stream()
                .filter(postSeedDto -> {
                    boolean isValid = validationUtil.isValid(postSeedDto);

                    User byUserName = userService.getUserByUserName(postSeedDto.getUser().getUsername());
                    Picture byPath = pictureService.getPictureByPath(postSeedDto.getPicture().getPath());
                    if (byUserName == null || byPath == null) {
                        isValid = false;
                    }

                    sb
                            .append(isValid ? String.format("Successfully imported Post, made by %s",
                                    postSeedDto.getUser().getUsername())
                                    : "Invalid Post")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(postSeedDto -> {
                    Post post = modelMapper.map(postSeedDto, Post.class);
                    User user = userService.getUserByUserName(postSeedDto.getUser().getUsername());
                    Picture picture = pictureService.getPictureByPath(postSeedDto.getPicture().getPath());

                    post.setUser(user);
                    post.setPicture(picture);

                    return post;
                })
                .forEach(postRepository::save);

        return sb.toString();
    }
}
