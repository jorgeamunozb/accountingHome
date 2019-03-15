package co.com.ceiba;

import co.com.ceiba.model.service.DatabaseSingletonService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {

        /* Creation of the statement instance */
        DatabaseSingletonService.getInstance();
        Statement state = DatabaseSingletonService.getStatement();
        /* put your SQL code in the variable sqlString */
        String sqlString = "SELECT 1 + 1;";
        ResultSet result = state.executeQuery(sqlString);
        while (result.next()) {
            String resultString = result.getString(1);
            System.out.println(resultString);
        }
    }

}