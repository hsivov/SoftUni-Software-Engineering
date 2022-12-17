package ExamPrep.football.core;

import ExamPrep.football.common.ConstantMessages;
import ExamPrep.football.common.ExceptionMessages;
import ExamPrep.football.entities.field.ArtificialTurf;
import ExamPrep.football.entities.field.Field;
import ExamPrep.football.entities.field.NaturalGrass;
import ExamPrep.football.entities.player.Men;
import ExamPrep.football.entities.player.Player;
import ExamPrep.football.entities.player.Women;
import ExamPrep.football.entities.supplement.Liquid;
import ExamPrep.football.entities.supplement.Powdered;
import ExamPrep.football.entities.supplement.Supplement;
import ExamPrep.football.repositories.SupplementRepository;
import ExamPrep.football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private SupplementRepository supplement;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {

        if (!(fieldType.equals("ArtificialTurf") || fieldType.equals("NaturalGrass"))) {
            throw new NullPointerException(ExceptionMessages.INVALID_FIELD_TYPE);
        }
        Field field;
        switch (fieldType) {
            case "ArtificialTurf":
                field = new ArtificialTurf(fieldName);
                fields.add(field);
                break;
            case "NaturalGrass":
                field = new NaturalGrass(fieldName);
                fields.add(field);
                break;
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {

        Supplement s;

        if (type.equals("Powdered")) {
            s = new Powdered();
        } else if (type.equals("Liquid")) {
            s = new Liquid();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }
        supplement.add(s);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {

        Field field = getFieldByName(fieldName);
        Supplement s = supplement.findByType(supplementType);

        if (s == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
        }

        field.addSupplement(s);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }


    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {

        Field field = getFieldByName(fieldName);
        Player player;

        switch (playerType) {
            case "Men":
                player = new Men(playerName, nationality, strength);
                break;
            case "Women":
                player = new Women(playerName, nationality, strength);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }

        if (field.getClass().getSimpleName().equals("ArtificialTurf") && playerType.equals("Women")) {
            field.addPlayer(player);
        } else if (field.getClass().getSimpleName().equals("NaturalGrass") && playerType.equals("Men")) {
            field.addPlayer(player);
        } else {
            return ConstantMessages.FIELD_NOT_SUITABLE;
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {

        Field field = getFieldByName(fieldName);

        for (Player player : field.getPlayers()) {
            player.stimulation();
        }

        return String.format(ConstantMessages.PLAYER_DRAG, field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {

        Field field = getFieldByName(fieldName);

        int sumPlayersStrength = field.getPlayers().stream()
                .map(Player::getStrength)
                .mapToInt(Integer::intValue)
                .sum();

        return String.format(ConstantMessages.STRENGTH_FIELD, fieldName, sumPlayersStrength);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        for (Field field : fields) {
            sb.append(field.getInfo());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private Field getFieldByName(String fieldName) {
        return fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);
    }
}
