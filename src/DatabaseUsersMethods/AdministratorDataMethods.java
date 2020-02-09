/*
 * Created by IntelliJ IDEA.
 * User: kanishk
 * Date: 08/02/20
 * Time: 2:56 PM
 */
package DatabaseUsersMethods;

import DatabaseUsers.Administrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdministratorDataMethods {
    public boolean addNewAdministrator(Connection connection, Administrator administrator) throws SQLException {
        String query = "INSERT INTO ADMIN_DB_USERS(username, password) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, administrator.getUsername());
        preparedStatement.setString(2, administrator.getPassword());
        int rowsReturned = preparedStatement.executeUpdate();
        return rowsReturned >= 1;

    }

    public boolean checkAdminUserAuthenticity(Connection connection, Administrator administrator) throws SQLException {
        String query = "SELECT * FROM ADMIN_DB_USERS WHERE USERNAME = (?) AND PASSWORD = (?);";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, administrator.getUsername());
        preparedStatement.setString(2, administrator.getPassword());
        int rowsReturned = preparedStatement.executeUpdate();
        return rowsReturned == 1;

    }
}
