package softuni.exam.service;

import softuni.exam.models.entity.Part;

import java.io.IOException;
import java.util.Optional;


public interface PartsService {

    boolean areImported();

    String readPartsFileContent() throws IOException;

    String importParts() throws IOException;

    Part getPartById(Long partId);
}
