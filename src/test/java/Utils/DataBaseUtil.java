package Utils;

import java.sql.*;

public class DataBaseUtil {

private static Connection connection;
private  static Statement statement;
private static ResultSet resultSet;

    public static void createConnection() throws SQLException {
        String url= "jdbc:oracle:thin:@ec2-54-159-174-62.compute-1.amazonaws.com:1521:xe";
        String username="hr";
        String password="hr";




                try{
                connection=DriverManager.getConnection(url,username,password);
                    System.out.println("Connection created successfully.");
                }catch (SQLException throwables){
                    System.out.println("Connection failed..!!");
                }

    }
    public static ResultSet runQuery(String query)  {
        try{
        statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        resultSet=statement.executeQuery(query);
        }catch (SQLException throwables){
            System.out.println("An error occurred while executing Query");
        }
        return resultSet;

    }

    public static  void closeConnection(){
        try {
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Connection closed successfully");
        }catch(SQLException throwables){
            System.out.println("An error occurred while closing connection");
        }
    }
}
