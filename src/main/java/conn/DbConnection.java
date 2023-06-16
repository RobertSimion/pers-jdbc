package conn;

import lombok.Builder;
import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Builder
public class DbConnection {

    private final String databaseDriver;
    @Getter
    private final String databaseUrl;
    private final String username;
    private final String password;
    private final String maxPool;

    @Getter
    private Connection connection;
    private Properties properties;

    public Connection connect() {
        if (connection == null) {
            try {
                Class.forName(databaseDriver);
                connection = DriverManager.getConnection(databaseUrl, getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", username);
            properties.setProperty("password", password);
            properties.setProperty("MaxPooledStatements", maxPool);
        }
        return properties;
    }
}
