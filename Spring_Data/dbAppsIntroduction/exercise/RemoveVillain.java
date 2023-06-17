package dbAppsIntroduction.exercise;

import java.sql.*;
import java.util.Scanner;

public class RemoveVillain {
    // SQL queries
    private static final String GET_VILLAIN_NAME_BY_ID = "SELECT name FROM villains WHERE id = ?;";
    private static final String GET_COUNT_MINIONS_BY_VILLAIN_ID =
            "SELECT COUNT(*) AS m_count FROM minions_villains WHERE villain_id = ?;";
    private static final String DELETE_MINIONS_BY_VILLAIN_ID =
            "DELETE m FROM minions_villains m WHERE villain_id = ?;";
    private static final String DELETE_VILLAIN_BY_ID = "DELETE v FROM villains v WHERE id = ?;";

    //Print formats
    private static final String COUNT_RELEASED_MINIONS = "%d minions released";
    private static final String VILLAIN_DELETED = "%s was deleted";
    private static final String NO_SUCH_VILLAIN_FOUND = "No such villain was found";

    public static void main(String[] args) throws SQLException {
        Connection sqlConnection = Utils.getSqlConnection();

        int villainId = new Scanner(System.in).nextInt();

        PreparedStatement selectVillain = sqlConnection.prepareStatement(GET_VILLAIN_NAME_BY_ID);
        selectVillain.setInt(1, villainId);

        ResultSet villainResultSet = selectVillain.executeQuery();

        if (!villainResultSet.next()) {
            System.out.println(NO_SUCH_VILLAIN_FOUND);
            sqlConnection.close();
            return;
        }

        String villainName = villainResultSet.getString(1);

        PreparedStatement countMinions = sqlConnection.prepareStatement(GET_COUNT_MINIONS_BY_VILLAIN_ID);
        countMinions.setInt(1, villainId);

        ResultSet countMinionsResultSet = countMinions.executeQuery();
        countMinionsResultSet.next();

        int countOfReleasedMinions = countMinionsResultSet.getInt(1);

        sqlConnection.setAutoCommit(false);

        try {
            PreparedStatement deleteMinions = sqlConnection.prepareStatement(DELETE_MINIONS_BY_VILLAIN_ID);
            PreparedStatement deleteVillain = sqlConnection.prepareStatement(DELETE_VILLAIN_BY_ID);

            deleteMinions.setInt(1, villainId);
            deleteMinions.executeUpdate();

            deleteVillain.setInt(1, villainId);
            deleteVillain.executeUpdate();

            sqlConnection.commit();
            System.out.printf(VILLAIN_DELETED, villainName);
            System.out.println();
            System.out.printf(COUNT_RELEASED_MINIONS, countOfReleasedMinions);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            sqlConnection.rollback();
        }
        sqlConnection.close();
    }
}
