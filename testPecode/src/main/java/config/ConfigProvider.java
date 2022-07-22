package config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.load("testvalue.conf");
    }

    String URL = readConfig().getString("base.url");
    String LOGIN = readConfig().getString("user.login");
    String PASSWORD = readConfig().getString("user.password");
}
