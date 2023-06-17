package dbAppsIntroduction.exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetVillainsNames {
    private static final String GET_VILLAINS_NAMES = """
            SELECT v.name, COUNT(DISTINCT mv.minion_id) AS 'count_of_minions'
                                    FROM villains v
                                    JOIN minions_villains mv ON v.id = mv.villain_id
                                    GROUP BY v.name
                                    HAVING count_of_minions > ?
                                    ORDER BY count_of_minions DESC;""";
    public static void main(String[] args) throws SQLException {

        Connection connection = Utils.getSqlConnection();

        PreparedStatement preparedStatement = connection
                .prepareStatement(GET_VILLAINS_NAMES);
        preparedStatement.setInt(1, 15);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + " " + resultSet.getInt(2));
        }

        connection.close();
    }
}
