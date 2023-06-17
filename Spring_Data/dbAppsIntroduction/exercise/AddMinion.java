package dbAppsIntroduction.exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddMinion {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection connection = Utils.getSqlConnection();

//        Minion: Robert 14 Berlin
//        Villain: Gru
        String[] minionInfo = scanner.nextLine().split(" ");
        String minionName = minionInfo[1];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String minionTown = minionInfo[3];
        String villainName = scanner.nextLine().split(" ")[1];

//      Методите getOrInsertTown и getOrInsertVillain връщат съответно id на villain и на town, ако
//      съществуват такива. Ако няма такива се създават, инсъртват в БД и се връщат id-та на ново създадените.

        int townId = getOrInsertTown(connection, minionTown);
        int villainId = getOrInsertVillain(connection, villainName);

        PreparedStatement insertMinion = connection.prepareStatement(
                "INSERT INTO minions(name, age, town_id) VALUES(?, ?, ?)");
        insertMinion.setString(1, minionName);
        insertMinion.setInt(2, minionAge);
        insertMinion.setInt(3, townId);
        insertMinion.executeUpdate();

        PreparedStatement getLastMinion = connection.prepareStatement(
                "SELECT id FROM minions ORDER BY id DESC LIMIT 1");
        ResultSet lastMinionSet = getLastMinion.executeQuery();
        lastMinionSet.next();
        int lastMinionId = lastMinionSet.getInt("id");

        PreparedStatement insertMinionsVillains = connection.prepareStatement(
                "INSERT INTO minions_villains VALUES (?, ?)"
        );
        insertMinionsVillains.setInt(1, lastMinionId);
        insertMinionsVillains.setInt(2, villainId);
        insertMinionsVillains.executeUpdate();

        System.out.printf("Successfully added %s to be minion of %s.%n",
                minionName, villainName);

        connection.close();
    }

    private static int getOrInsertVillain(Connection connection, String villainName) throws SQLException {
        PreparedStatement selectVillain = connection
                .prepareStatement("SELECT id FROM villains WHERE name = ?;");

        selectVillain.setString(1, villainName);
        ResultSet resultSet = selectVillain.executeQuery();

        int villainId;
        if (!resultSet.next()) {
            PreparedStatement insertVillain = connection
                    .prepareStatement("INSERT INTO villains(name, evilness_factor) VALUES (?, ?);");

            insertVillain.setString(1, villainName);
            insertVillain.setString(2, "evil");
            insertVillain.executeUpdate();

            ResultSet newVillainSet = selectVillain.executeQuery();
            newVillainSet.next();
            villainId = newVillainSet.getInt("id");
            System.out.printf("Villain %s was added to the database.%n", villainName);
        } else {
            villainId = resultSet.getInt("id");
        }
        return villainId;
    }

    private static int getOrInsertTown(Connection connection, String town) throws SQLException {
        PreparedStatement selectTown = connection.prepareStatement("SELECT id FROM towns WHERE name = ?;");

        selectTown.setString(1, town);

        ResultSet resultSet = selectTown.executeQuery();

        int townId;
        if (!resultSet.next()) {
            PreparedStatement insertTown = connection
                    .prepareStatement("INSERT INTO towns(name) VALUES (?);");
            insertTown.setString(1, town);
            insertTown.executeUpdate();

            ResultSet newTownSet = selectTown.executeQuery();
            newTownSet.next();
            townId = newTownSet.getInt("id");
            System.out.printf("Town %s was added to the database.%n", town);
        } else {
            townId = resultSet.getInt("id");
        }
        return townId;
    }
}
