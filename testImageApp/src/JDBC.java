import java.sql.*;

public class JDBC {

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/datas", "root", "password");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from images");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("path"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
