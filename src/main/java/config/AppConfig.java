package config;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppConfig {
    UiSettings uiSettings;
    DbSettings dbSettings;
}
