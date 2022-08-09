
import java.sql.*;

public class ConnectionDB {
    public static void main(String[] args) throws SQLException {
String dbUrl= "jdbc:oracle:thin:@ec2-54-159-174-62.compute-1.amazonaws.com:1521:xe";
String username="hr";
String password="hr";


 /*try{
     connection=DriverManager.getConnection(dbUrl,username,password);
     System.out.println("Connection created successfully");
 }catch (SQLException throwables){
     System.out.println("Connection failed....");
 }*/
// 1 step create a connection
     Connection connection=DriverManager.getConnection(dbUrl,username,password);
// 2 step create statement  which will execute the queries and get the result

Statement statement=connection.createStatement();

// 3 step store
        ResultSet resultSet=statement.executeQuery("select * from countries");
        resultSet.next();
        System.out.println("First Column Value:"+resultSet.getString(1));
        System.out.println("First Column Value:"+resultSet.getString(2));
        System.out.println(resultSet.getString("region_id"));
        resultSet.next();
        System.out.println("                                                       ");
        System.out.println("First Column Value:"+resultSet.getString(1));
        System.out.println("First Column Value:"+resultSet.getString(2));
        System.out.println(resultSet.getString("region_id"));

        resultSet.next();
        System.out.println("                                                               ");
        System.out.println("First Column Value:"+resultSet.getString(1));
        System.out.println("First Column Value:"+resultSet.getString(2));
        System.out.println(resultSet.getString("region_id"));
      //  System.out.println(resultSet.getString(4));//SQLException: Invalid column index

        resultSet=statement.executeQuery("select * from countries");
        //resultSet.next();

        System.out.println("          ");

        int i=0;

        while(resultSet.next()){
            i=i+1;
            System.out.print(i+"-"+resultSet.getString("country_id")+"\t"+resultSet.getString("country_name")+"\t"+resultSet.getString("region_id"));
            System.out.println("                                                    ");
        }

        resultSet.close();
        statement.close();
        connection.close();
        // set up and teardown


    }
}
