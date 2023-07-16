package com.example.football.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface PlayerService {
    boolean areImported();

    String readPlayersFileContent() throws IOException;

    String importPlayers() throws JAXBException;

    String exportBestPlayers();
}
