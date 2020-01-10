package connection;

import java.sql.Connection;

public class DatabaseConnection {
    private static final String URL = "";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static Connection connection = null;

    public static Connection getConnection() {
        return connection;
    }

}
