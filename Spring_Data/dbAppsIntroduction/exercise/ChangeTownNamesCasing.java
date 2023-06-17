package dbAppsIntroduction.exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeTownNamesCasing {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = Utils.getSqlConnection();

        PreparedStatement updateTownByCountry = connection
                .prepareStatement("UPDATE towns SET name = UPPER(name) WHERE country = ?;");

        String country = scanner.nextLine();
        updateTownByCountry.setString(1, country);
        updateTownByCountry.executeUpdate();

        PreparedStatement selectTownsByCountry = connection
                .prepareStatement("SELECT name FROM towns WHERE country = ?;");

        selectTownsByCountry.setString(1, country);

        ResultSet townsSet = selectTownsByCountry.executeQuery();

        List<String> affectedTowns = new ArrayList<>();
        while (townsSet.next()) {
            String townName = townsSet.getString("name");
            affectedTowns.add(townName);
        }

        if (affectedTowns.isEmpty()) {
            System.out.println("No town names were affected.");
            connection.close();
            return;
        }

        System.out.printf("%d town names were affected.%n", affectedTowns.size());
        System.out.printf("[%s]", String.join(", ", affectedTowns));

        connection.close();
    }
}
