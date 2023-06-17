package dbAppsIntroduction.exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrintAllMinionNames {
    private static final String GET_MINION_NAMES = "SELECT name FROM minions;";

    public static void main(String[] args) throws SQLException {
        Connection sqlConnection = Utils.getSqlConnection();

        PreparedStatement selectMinionNames = sqlConnection.prepareStatement(GET_MINION_NAMES,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        ResultSet minionNamesSet = selectMinionNames.executeQuery();

        int minionsCount = 0;

        while (minionNamesSet.next()) minionsCount++;

        minionNamesSet.beforeFirst();

        int firstIndex = 1;
        int lastIndex = minionsCount;

        for (int i = 1; i < minionsCount + 1; i++) {
            if (i % 2 != 0) {
                minionNamesSet.absolute(firstIndex);
                firstIndex++;
            } else {
                minionNamesSet.absolute(lastIndex);
                lastIndex--;
            }

            System.out.println(minionNamesSet.getString("name"));
            minionNamesSet.next();
        }
    }
}
