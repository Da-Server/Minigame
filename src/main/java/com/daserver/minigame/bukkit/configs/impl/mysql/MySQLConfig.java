package com.daserver.minigame.bukkit.configs.impl.mysql;

import com.daserver.minigame.Minigame;
import com.daserver.minigame.bukkit.configs.AbstractYamlConfiguration;
import com.daserver.minigame.bukkit.configs.exceptions.InvalidFileExtensionException;

import java.io.File;

/**
 * This configuration is responsible for the MySQL database credentials
 * @see AbstractYamlConfiguration
 */
public class MySQLConfig extends AbstractYamlConfiguration<MySQLConfigData> {

    private static MySQLConfig instance;

    private MySQLConfig() throws InvalidFileExtensionException {
        super(new File(Minigame.getInstance().getDataFolder(), "mySQL.yml"));
    }


    public static MySQLConfig get() {
        if (instance == null) {
            try {
                instance = new MySQLConfig();
            } catch (InvalidFileExtensionException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }


    @Override
    protected MySQLConfigData getDefaultData() {
        return new MySQLConfigData();
    }
}
