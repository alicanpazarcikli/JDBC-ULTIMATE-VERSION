import Utils.DataBaseUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DataBaseCountriesTable {


    @BeforeTest
    public void setup() throws SQLException {
        DataBaseUtil.createConnection();
    }
    public void tearDown(){
        DataBaseUtil.closeConnection();
    }
    @Test(description = "Given connected database and countries table when we check the column number then it must be equal to given data")
    public void ColumnNumber() throws SQLException {
        //Given
        ResultSet resultSet=DataBaseUtil.runQuery("Select * from countries");
        int expectedNUmberOfColumnsInCountriesTable=3;

        //When
        ResultSetMetaData resultSetMetaData=null;
        try{
           resultSetMetaData=resultSet.getMetaData();
        }catch(SQLException throwables){
            System.out.println("System could not get Meta Data");
        }
        int actualNUmberOfColumnsInCountriesTable=resultSetMetaData.getColumnCount();

        //Then
        Assert.assertEquals(actualNUmberOfColumnsInCountriesTable,expectedNUmberOfColumnsInCountriesTable,"Countries table column count is incorrect");

    }
    @Test(description = "Given connected database and countries table when we check the first column it must be equal")
    public void columnName() throws SQLException {
        // Given
        ResultSet resultSet=DataBaseUtil.runQuery("Select * from countries");
        String expectedColumnName="COUNTRY_ID";
        //When
        ResultSetMetaData resultSetMetaData=null;
        String actualColumnName="";
        try{
            resultSetMetaData=resultSet.getMetaData();
            actualColumnName=resultSetMetaData.getColumnName(1);

        }catch(SQLException throwables){
            System.out.println("System could not get Meta Data");
        }
        Assert.assertEquals(actualColumnName,expectedColumnName,"Column name mismatched.");

    }
}
