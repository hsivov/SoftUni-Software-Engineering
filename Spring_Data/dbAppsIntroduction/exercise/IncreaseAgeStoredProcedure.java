package dbAppsIntroduction.exercise;

import java.sql.*;
import java.util.Scanner;

public class IncreaseAgeStoredProcedure {
    private static final String CALL_UPS_GET_OLDER_PROCEDURE =
            "CALL usp_get_older(?);";
    private static final String GET_MINION_NAME_AGE_BY_ID =
            "SELECT name, age FROM minions WHERE id = ?;";
    private static final String PRINT_RESULT_FORMAT = "%s %d";

    public static void main(String[] args) throws SQLException {
        Connection connection = Utils.getSqlConnection();

        int minionId = new Scanner(System.in).nextInt();

        CallableStatement callableStatement = connection.prepareCall(CALL_UPS_GET_OLDER_PROCEDURE);
        callableStatement.setInt(1, minionId);
        callableStatement.executeUpdate();

        printMinionInfo(connection, minionId);

        connection.close();
    }

    private static void printMinionInfo(Connection connection, int minionId) throws SQLException {
        PreparedStatement selectMinion = connection.prepareStatement(GET_MINION_NAME_AGE_BY_ID);
        selectMinion.setInt(1, minionId);

        ResultSet rs = selectMinion.executeQuery();
        rs.next();

        System.out.printf(PRINT_RESULT_FORMAT, rs.getString("name"), rs.getInt("age"));
    }
}
