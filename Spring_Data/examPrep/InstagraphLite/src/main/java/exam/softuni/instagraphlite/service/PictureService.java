package exam.softuni.instagraphlite.service;

import exam.softuni.instagraphlite.models.entity.Picture;

import java.io.IOException;

public interface PictureService {
    boolean areImported();
    String readFromFileContent() throws IOException;
    String importPictures() throws IOException;

    Picture getPictureByPath(String path);

    String exportPictures();

}
