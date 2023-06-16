package util;

import conn.DbConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TruncateUtil {

    public static void truncate(DbConnection dbConnection) {
        try {
            String deleteEmployeeDetails = "DELETE FROM employee_details";
            String deleteEmployee = "DELETE FROM employee";
            String deletePayroll = "DELETE FROM payroll";

            PreparedStatement statement1 = dbConnection.connect().prepareStatement(deleteEmployeeDetails);
            PreparedStatement statement2 = dbConnection.getConnection().prepareStatement(deleteEmployee);
            PreparedStatement statement3 = dbConnection.getConnection().prepareStatement(deletePayroll);

            dbConnection.getConnection().setAutoCommit(false);
            statement1.executeUpdate();
            statement2.executeUpdate();
            statement3.executeUpdate();
            dbConnection.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.disconnect();
        }
    }
}
