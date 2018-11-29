package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static final String server = "NC-DOCKER1";
    static final String port = "26470";
    static final String db = "RecipesExample";
    static final String user = "sa";
    static final String password = "AaSql!6Ora";

    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:sqlserver://%s:%s;database=%s;user=%s;password=%s",
                server, port, db, user, password);
        return DriverManager.getConnection(url);
    }
}
