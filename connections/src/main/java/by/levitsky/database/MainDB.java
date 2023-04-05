package by.levitsky.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainDB {
    public static void main(String[] args) {
        DBWorker dbWorker = new DBWorker();

        String query = "select * from users where id=2";
        try {
            Statement statement = dbWorker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                User user=new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString(3));

                System.out.println(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
