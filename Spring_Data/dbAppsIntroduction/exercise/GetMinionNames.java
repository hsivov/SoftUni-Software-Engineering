package dbAppsIntroduction.exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetMinionNames {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection connection = Utils.getSqlConnection();

        int villainId = Integer.parseInt(scanner.nextLine());
        PreparedStatement getVillainNameById = connection
                .prepareStatement("SELECT name FROM villains WHERE id = ?;");

        getVillainNameById.setInt(1, villainId);

        ResultSet villainName = getVillainNameById.executeQuery();

        if (!villainName.next()) {
            System.out.printf("No villain with ID %d exists in the database.", villainId);
            connection.close();
            return;
        }

        PreparedStatement getMinionsNamesByVillainId = connection
                .prepareStatement("""
                        SELECT m.name, m.age
                        FROM minions m
                        JOIN minions_villains mv ON m.id = mv.minion_id
                        WHERE villain_id = ?;""");

        getMinionsNamesByVillainId.setInt(1, villainId);

        ResultSet resultMinionsNames = getMinionsNamesByVillainId.executeQuery();

        System.out.printf("Villain: %s%n", villainName.getString("name"));
        int minionsCount = 1;
        while (resultMinionsNames.next()) {
            System.out.printf("%d. %s %s%n",
                    minionsCount,
                    resultMinionsNames.getString("name"),
                    resultMinionsNames.getString("age"));
            minionsCount++;
        }

        connection.close();
    }
}
