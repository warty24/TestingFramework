package db;

import config.ConfigManager;
import config.DbSettings;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Database {
    public static Database db = new Database();
    public static DbSettings settings;
    final String url;
    final String user;
    final String password;


    public Database() {
    settings = ConfigManager.getConfiguration().getDbSettings();
     url = buildConnectionString();
     user = settings.getUserName();
     password = settings.getUserPassword();
    }
    private String buildConnectionString() {
        return String.format("jdbc:%s://%s/%s",
                settings.getDbType(),
                settings.getDbAddress(),
                settings.getDbName());
//        return "jdbc:" + settings.getDbType() + "://" + settings.getDbAddress() + "/" + settings.getDbName();
    }

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
