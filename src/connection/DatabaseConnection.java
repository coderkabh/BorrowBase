/*
 * Created by IntelliJ IDEA.
 * User: Kanishk
 * Date: 11/01/20
 * Time: 11:23 PM
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/BorrowBaseDB";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;

    public static Connection getConnection() {
        return connection;
    }

    public boolean establishConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection != null;
    }

    public void printConnectionStatus() {
        if (getConnection() != null) {
            System.out.println("\nConnection is active\n");
        } else {
            System.out.println("\nConnection is inactive\n");
        }
    }

    public boolean getConnectionStatus() throws SQLException {
        boolean response = false;
        if (getConnection() != null) response = true;
        return response;
    }

}
