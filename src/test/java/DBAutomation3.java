import Utils.DataBaseUtil;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DBAutomation3 {
    public static void main(String[] args) throws SQLException {
        DataBaseUtil.createConnection();
        ResultSet resultSet=DataBaseUtil.runQuery("SELECT * FROM employees");
        resultSet.next();
        System.out.println(resultSet.getString(1));

        //Meta Data
        //column count
        ResultSetMetaData rsmd=resultSet.getMetaData();
        int actualNumberOfColumnInEmployeeTable=rsmd.getColumnCount();
        int  expectedNumberOfColumnInEmployeeTable=11;
        System.out.println(rsmd.getColumnCount());

       for(int i=1;i<=rsmd.getColumnCount();i++){
           System.out.println(rsmd.getColumnName(i));
       }
        System.out.println(rsmd.getColumnName(2));
    }
}
