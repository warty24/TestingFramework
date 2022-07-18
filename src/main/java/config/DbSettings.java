package config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DbSettings {
    String dbType;
    String dbAddress;
    String dbName;
    String userName;
    String userPassword;
}
