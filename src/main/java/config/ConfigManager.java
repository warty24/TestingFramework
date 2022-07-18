package config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigRenderOptions;
import utils.JsonConverter;

public abstract class ConfigManager {

    public static AppConfig getConfiguration() {
        Config config = ConfigFactory.load();
        String json = config.root().render(ConfigRenderOptions.concise());
        return JsonConverter.fromJson(json, AppConfig.class);
    }

}
