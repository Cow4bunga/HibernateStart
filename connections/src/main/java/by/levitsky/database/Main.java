package by.levitsky.database;

import java.sql.*;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "mario_123_1452";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement()) {
            if (!connection.isClosed()) {
                System.out.println("We are connected!");
            }

            statement.execute("INSERT INTO  animal(animal_name, animal_desc) VALUES('name1','desc1');");

            statement.addBatch("INSERT INTO  animal(animal_name, animal_desc) VALUES('name2','desc2');");
            statement.addBatch("INSERT INTO  animal(animal_name, animal_desc) VALUES('name3','desc3');");
            statement.addBatch("INSERT INTO  animal(animal_name, animal_desc) VALUES('name4','desc4');");

            statement.executeBatch();
            statement.clearBatch();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM animal");

            statement.executeUpdate("UPDATE animal set animal_name='aboba' where id=1");

        } catch (SQLException e) {
            System.out.println("there is no connection... Exception!");
        }
    }
}
