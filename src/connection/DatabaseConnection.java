package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "";
    private static final String USERNAME = "";
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
            System.out.println("Connection is active");
        } else {
            System.out.println("Connection is inactive");
        }

    }
}
