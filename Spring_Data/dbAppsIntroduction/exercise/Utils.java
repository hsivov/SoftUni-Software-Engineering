package dbAppsIntroduction.exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static dbAppsIntroduction.exercise.Properties.*;

public enum Utils {
    ;
    static Connection getSqlConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty(USER_KEY,USER_VALUE);
        properties.setProperty(PASSWORD_KEY,PASSWORD_VALUE);

        return DriverManager.getConnection(JDBC_MYSQL_URL, properties);
    }
}
