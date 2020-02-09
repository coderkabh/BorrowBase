/*
 * Created by IntelliJ IDEA.
 * User: kanishk
 * Date: 08/02/20
 * Time: 2:58 PM
 */
package DatabaseUsersMethods;

import DatabaseUsers.NaiveUsers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NaiveUsersDataMethods {
    public boolean addNewNaiveUser(Connection connection, NaiveUsers naiveUsers) throws SQLException {
        String query = "INSERT INTO NAIVE_DB_USERS(username, password) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, naiveUsers.getUsername());
        preparedStatement.setString(2, naiveUsers.getPassword());
        int rowsReturned = preparedStatement.executeUpdate();
        return rowsReturned >= 1;

    }

    public boolean checkNaiveUserAuthenticity(Connection connection, NaiveUsers naiveUsers) throws SQLException {
        String query = "SELECT * FROM ADMIN_DB_USERS WHERE USERNAME = (?) AND PASSWORD = (?);";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, naiveUsers.getUsername());
        preparedStatement.setString(2, naiveUsers.getPassword());
        int rowsReturned = preparedStatement.executeUpdate();
        return rowsReturned == 1;

    }
}
