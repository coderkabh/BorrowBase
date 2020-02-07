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


    /*
     * This method will return connection
     */
    public static Connection getConnection() {
        return connection;
    }

    /*
     * This method will establish connection and return true if connection is established
     */
    public boolean establishConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection != null;
    }

    /*
     * This method will print connection status
     */
    public void printConnectionStatus() {
        if (getConnection() != null) {
            System.out.println("\nConnection is active\n");
        } else {
            System.out.println("\nConnection is inactive\n");
        }
    }

    /*
     * This method will return true if connection is established else false
     */
    public boolean getConnectionStatus() throws SQLException {
        boolean response = false;
        if (getConnection() != null) response = true;
        return response;
    }

}
