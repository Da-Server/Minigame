package com.daserver.minigame.bukkit.configs.impl.chat.placeholders;

import com.daserver.minigame.Minigame;
import com.daserver.minigame.bukkit.configs.AbstractYamlConfiguration;
import com.daserver.minigame.bukkit.configs.exceptions.InvalidFileExtensionException;

import java.io.File;

/**
 * This configuration is responsible for chat place-holders
 * @see AbstractYamlConfiguration
 */
public class ChatPlaceHoldersConfig extends AbstractYamlConfiguration<ChatPlaceHoldersConfigData> {

    private static ChatPlaceHoldersConfig instance;

    private ChatPlaceHoldersConfig() throws InvalidFileExtensionException {
        super(new File(Minigame.getInstance().getDataFolder(), "manhuntConfig.yml"));
    }

    public static ChatPlaceHoldersConfig get() {
        if (instance == null) {
            try {
                instance = new ChatPlaceHoldersConfig();
            } catch (InvalidFileExtensionException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    @Override
    protected ChatPlaceHoldersConfigData getDefaultData() {
        return new ChatPlaceHoldersConfigData();
    }
}
