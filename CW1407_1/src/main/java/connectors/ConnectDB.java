package connectors;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/MyTestDB";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "postgres";

    public static Connection Connected(){
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (Exception e) {
            return null;
        }
    }
}
