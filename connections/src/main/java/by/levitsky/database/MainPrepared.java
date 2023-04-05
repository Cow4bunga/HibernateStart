package by.levitsky.database;

import java.sql.*;

public class MainPrepared {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "mario_123_1452";

    private static final String INSERT_Q = "INSERT INTO animal VALUES(?,?,?);";
    private static final String GET_ALL = "SELECT * FROM users;";

    private static final String DELETE_Q = "DELETE FROM animal WHERE id=13;";



    public static void main(String[] args) {
        PreparedStatement preparedStatement = null;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement()) {
            if (!connection.isClosed()) {
                System.out.println("We are connected!");
            }

            preparedStatement=connection.prepareStatement(DELETE_Q);
            preparedStatement.executeUpdate();

//            preparedStatement = connection.prepareStatement(INSERT_Q);
//            preparedStatement.setInt(1, 13);
//            preparedStatement.setString(2, "aboba");
//            preparedStatement.setString(3, "amogus");
//
//            preparedStatement.execute();

            preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                User user=new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString(3));

                System.out.println(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
