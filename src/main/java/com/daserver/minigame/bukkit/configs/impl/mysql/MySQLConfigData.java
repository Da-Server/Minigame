package com.daserver.minigame.bukkit.configs.impl.mysql;

import lombok.Getter;
import lombok.Setter;
import com.daserver.minigame.bukkit.configs.AbstractYamlConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is a data holder for MySQL configuration
 * @see MySQLConfig
 * @see AbstractYamlConfiguration
 */
@Getter
@Setter
public class MySQLConfigData implements ConfigurationSerializable {

    private String dbName;
    private String dbHost;
    private String dbUser;
    private String dbPassword;
    private int dbPort;

    protected MySQLConfigData() {
        // defaults
        this.dbName = "plutoser_daserver1 ";
        this.dbHost = "";
        this.dbUser = "";
        this.dbPassword = "";
        this.dbPort = 3306;
    }


    @Override
    public Map<String, Object> serialize() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("database_name", dbName);
        map.put("database_host", dbHost);
        map.put("databse_user", dbUser);
        map.put("databse_port", dbUser);
        return map;
    }
}
