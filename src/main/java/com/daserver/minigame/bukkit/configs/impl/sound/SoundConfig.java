package com.daserver.minigame.bukkit.configs.impl.sound;

import com.daserver.minigame.Minigame;
import com.daserver.minigame.bukkit.configs.AbstractYamlConfiguration;
import com.daserver.minigame.bukkit.configs.exceptions.InvalidFileExtensionException;
import com.daserver.minigame.bukkit.game.Game;

import java.io.File;

/**
 * This configuration is responsible for the sound values related to {@link Game}
 * @see AbstractYamlConfiguration
 */
public class SoundConfig extends AbstractYamlConfiguration<SoundConfigData> {

    private static SoundConfig instance;

    private SoundConfig() throws InvalidFileExtensionException {
        super(new File(Minigame.getInstance().getDataFolder(), "soundsConfig.yml"));
    }

    public static SoundConfig get() {
        if (instance == null) {
            try {
                instance = new SoundConfig();
            } catch (InvalidFileExtensionException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }


    @Override
    protected SoundConfigData getDefaultData() {
        return new SoundConfigData();
    }
}
