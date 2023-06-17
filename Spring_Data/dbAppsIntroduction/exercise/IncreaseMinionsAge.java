package dbAppsIntroduction.exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class IncreaseMinionsAge {
    private static final String UPDATE_MINION_AGE_BY_ID = "UPDATE minions SET age = age + 1 WHERE id = ?;";
    private static final String UPDATE_MINION_NAME_TO_LOWER =
            "UPDATE minions SET name = LOWER(name) WHERE id = ?;";

    private static final String GET_MINIONS = "SELECT name, age FROM minions;";

    public static void main(String[] args) throws SQLException {
        Connection sqlConnection = Utils.getSqlConnection();

        Scanner scanner = new Scanner(System.in);

        int[] minionIds = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int minionId : minionIds) {
            PreparedStatement updateAgeStatement = sqlConnection.prepareStatement(UPDATE_MINION_AGE_BY_ID);
            PreparedStatement updateNameStatement = sqlConnection.prepareStatement(UPDATE_MINION_NAME_TO_LOWER);

            updateAgeStatement.setInt(1, minionId);
            updateAgeStatement.executeUpdate();

            updateNameStatement.setInt(1, minionId);
            updateNameStatement.executeUpdate();
        }

        PreparedStatement selectMinions = sqlConnection.prepareStatement(GET_MINIONS);

        ResultSet minionsSet = selectMinions.executeQuery();

        while (minionsSet.next()) {
            System.out.printf("%s %d%n", minionsSet.getString("name"), minionsSet.getInt("age"));
        }

        sqlConnection.close();
    }
}
