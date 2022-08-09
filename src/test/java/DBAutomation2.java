import java.sql.*;

public class DBAutomation2 {
    public static void main(String[] args) throws SQLException {
        String dbUrl= "jdbc:oracle:thin:@ec2-54-159-174-62.compute-1.amazonaws.com:1521:xe";
        String username="hr";
        String password="hr";

        Connection connection= DriverManager.getConnection(dbUrl,username,password);
        Statement statement=connection.createStatement();
        ResultSet resultSet= statement.executeQuery("select * from employees");

        int i=0;
        while(resultSet.next()){
            i=i+1;
            System.out.println(i+"-"+resultSet.getString("employee_id")+" "+resultSet.getString("first_name")+" "+resultSet.getString("last_name"));
        }
        Statement statement1=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet1=statement1.executeQuery("SELECT * FROM countries ");
        //resultSet1.next();
        System.out.println(resultSet1.isAfterLast());
        System.out.println(resultSet1.isBeforeFirst());
        resultSet1.absolute(5);
        System.out.println(resultSet1.getString(2));

        resultSet.close();
        statement.close();
        connection.close();



    }
}
