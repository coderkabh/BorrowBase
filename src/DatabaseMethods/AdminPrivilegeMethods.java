/*
 * Created by IntelliJ IDEA.
 * User: kanishk
 * Date: 07/02/20
 * Time: 11:55 PM
 */
package DatabaseMethods;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminPrivilegeMethods {


    public boolean deleteAllTransactionData(Connection connection) throws SQLException {
        int rowsAffected = 0;
        try {

            String query = "DELETE FROM TRANSACTION";
            Statement statement = connection.createStatement();
            rowsAffected = statement.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("SQL Exception occurred" + e.getMessage());
        }
        return rowsAffected >= 1;
    }

    public boolean deleteAllCustomerData(Connection connection) throws SQLException {
        int rowsAffected = 0;
        try {
            String query = "DELETE FROM CUSTOMER";
            Statement statement = connection.createStatement();
            rowsAffected = statement.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("SQL Exception occurred" + e.getMessage());
        }
        return rowsAffected >= 1;

    }
}

