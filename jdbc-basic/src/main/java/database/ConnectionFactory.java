package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class ConnectionFactory {

  private ConnectionFactory() {
    throw new UnsupportedOperationException();
  }

  public static Connection getConnection() {
    Connection connection = null;

    HashMap<String, String> connectionSettings = DatabaseConfig.connectionSettingsURL();

    try {
      connection = DriverManager.getConnection(
        connectionSettings.get("connectionUrl"),
        connectionSettings.get("user"),
        connectionSettings.get("password"));
    } catch (SQLException e) {
      System.out.println("Failed when try to connect!");
      throw new RuntimeException(e);
    }

    return connection;
  }
}
