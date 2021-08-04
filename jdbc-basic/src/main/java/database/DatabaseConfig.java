package database;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class DatabaseConfig {

  public static HashMap<String, String> connectionSettingsURL() {
    try (InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream("connection.properties")) {
      Properties prop = new Properties();

      prop.load(input);

      String driver = prop.getProperty("jdbc.driver");
      String databaseAddress = prop.getProperty("db.address");
      String databaseName = prop.getProperty("db.name");
      String databasePort = prop.getProperty("db.port");
      String user = prop.getProperty("db.user.login");
      String password = prop.getProperty("db.user.password");

      StringBuilder URL = new StringBuilder("jdbc:")
        .append(driver)
        .append("://")
        .append(databaseAddress)
        .append(":" + databasePort)
        .append("/")
        .append(databaseName);

      String connectionUrl = URL.toString();

      HashMap<String, String> connectionSettings = new HashMap<>();

      connectionSettings.put("user", user);
      connectionSettings.put("password", password);
      connectionSettings.put("connectionUrl", connectionUrl);

      return connectionSettings;

    } catch (IOException e) {
      System.out.println("Failed when try to connect!");
      e.printStackTrace();
    }

    return null;
  }
}
