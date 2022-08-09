import Utils.DataBaseUtil;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DataBaseDepartmentsTable {
    @BeforeTest
    public void setUp() throws SQLException {
        DataBaseUtil.createConnection();
    }

    @AfterTest
    public void tearDown() {
        DataBaseUtil.closeConnection();
    }

    @Test(description = "Given connected database and departments table when we check the column number then it must be equal to given data")
    public void columnNumber() throws SQLException {
        //given
        ResultSet resultSet = DataBaseUtil.runQuery("SELECT * FROM DEPARTMENTS");
        int expectedNumberOfColumnsInCountriesTable = 4;
        //when
        ResultSetMetaData resultSetMetaData = null;
        int actualColumnCountsInDepartmentsTable = 0;
        try {
            resultSetMetaData = resultSet.getMetaData();
            actualColumnCountsInDepartmentsTable = resultSetMetaData.getColumnCount();
        } catch (SQLException throwables) {
            System.out.println("System could not get Meta Data");
        }
        //then
        Assert.assertEquals(actualColumnCountsInDepartmentsTable, expectedNumberOfColumnsInCountriesTable, "Column count mismatched");
    }

    @Test
    public void columnName() {
        ResultSet resultSet = DataBaseUtil.runQuery("SELECT * FROM DEPARTMENTS");
        String expectedColumnNameInDepartmentsTable = "DEPARTMENT_ID";
        ResultSetMetaData resultSetMetaData = null;

        String actualColumnNameInDepartmentsTable = "";


        try {
            resultSetMetaData = resultSet.getMetaData();
            actualColumnNameInDepartmentsTable = resultSetMetaData.getColumnName(1);

        } catch (SQLException throwables) {

        }
        Assert.assertEquals(actualColumnNameInDepartmentsTable, expectedColumnNameInDepartmentsTable, "Column name mismatched.");
    }


}
