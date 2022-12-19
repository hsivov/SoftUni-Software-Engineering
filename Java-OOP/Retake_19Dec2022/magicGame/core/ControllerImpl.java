package Retake_19Dec2022.magicGame.core;

import Retake_19Dec2022.magicGame.common.ExceptionMessages;
import Retake_19Dec2022.magicGame.common.OutputMessages;
import Retake_19Dec2022.magicGame.models.magicians.BlackWidow;
import Retake_19Dec2022.magicGame.models.magicians.Magician;
import Retake_19Dec2022.magicGame.models.magicians.Wizard;
import Retake_19Dec2022.magicGame.models.magics.BlackMagic;
import Retake_19Dec2022.magicGame.models.magics.Magic;
import Retake_19Dec2022.magicGame.models.magics.RedMagic;
import Retake_19Dec2022.magicGame.models.region.Region;
import Retake_19Dec2022.magicGame.models.region.RegionImpl;
import Retake_19Dec2022.magicGame.repositories.interfaces.MagicRepository;
import Retake_19Dec2022.magicGame.repositories.interfaces.MagicRepositoryImpl;
import Retake_19Dec2022.magicGame.repositories.interfaces.MagicianRepository;
import Retake_19Dec2022.magicGame.repositories.interfaces.MagicianRepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{

    private MagicRepository<Magic> magics;
    private MagicianRepository<Magician> magicians;
    private Region region;

    public ControllerImpl() {
        this.magics = new MagicRepositoryImpl();
        this.magicians = new MagicianRepositoryImpl();
        this.region = new RegionImpl();
    }

    @Override
    public String addMagic(String type, String name, int bulletsCount) {
        Magic magic;
        if (type.equals("RedMagic")) {
            magic = new RedMagic(name, bulletsCount);
        } else if (type.equals("BlackMagic")) {
            magic = new BlackMagic(name, bulletsCount);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_TYPE);
        }
        magics.addMagic(magic);

        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGIC, name);
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
        Magic magic = magics.findByName(magicName);
        if (magic == null) {
            throw new NullPointerException(ExceptionMessages.MAGIC_CANNOT_BE_FOUND);
        }

        Magician magician;
        if (type.equals("Wizard")) {
            magician = new Wizard(username, health, protection, magic);
        } else if (type.equals("BlackWidow")) {
            magician = new BlackWidow(username, health, protection, magic);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_TYPE);
        }
        magicians.addMagician(magician);

        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGICIAN, username);
    }

    @Override
    public String startGame() {

        List<Magician> aliveMagicians = magicians.getData().stream()
                .filter(Magician::isAlive)
                .collect(Collectors.toList());

        return region.start(aliveMagicians);
    }

    @Override
    public String report() {
        List<Magician> sorted = magicians.getData().stream()
                .sorted(Comparator.comparing(m -> m.getClass().getSimpleName()))
                .sorted(Comparator.comparing(Magician::getUsername))
                .sorted(Comparator.comparingInt(Magician::getHealth))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (Magician magician : sorted) {
            sb.append(System.lineSeparator());
            sb.append(magician);
        }
        return sb.toString();
    }
}
