package dbAppsIntroduction.lab;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Diablo {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "1aD3^4WZ5F");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", props);
        PreparedStatement stmt = conn.prepareStatement("SELECT first_name, last_name, COUNT(ug.game_id)" +
                "FROM users JOIN users_games ug ON users.id = ug.user_id WHERE user_name = ? GROUP BY ug.user_id");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        stmt.setString(1, username);

        ResultSet rs = stmt.executeQuery();

        if (!rs.next()) {
            System.out.println("No such user exists");
        } else {
            System.out.printf("User: %s%n%s %s has played %d games",
                    username, rs.getString("first_name"), rs.getString("last_name"), rs.getInt(3));
        }

        conn.close();
    }
}
