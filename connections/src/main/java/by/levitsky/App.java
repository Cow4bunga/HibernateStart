package by.levitsky;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * Hello world!
 */
public class App {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "mario_123_1452";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            if (!connection.isClosed()) {
                System.out.println("We are connected!");
            }
        } catch (SQLException e) {
            System.out.println("there is no connection... Exception!");
        }
    }
}
