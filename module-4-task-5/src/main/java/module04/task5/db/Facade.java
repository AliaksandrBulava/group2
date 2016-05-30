package module04.task5.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Kiryl_Parfiankou on 2/1/2016.
 */
public class Facade {

    public static void registerDriver() throws SQLException {
        DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
    }

    public static Connection getConnection(String url) throws SQLException {
        return DriverManager.getConnection(url);
    }

    public static Statement createStatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    public static int executeUpdate(Statement statement ,String script) throws SQLException {
        return statement.executeUpdate(script);
    }
}
