package com.daserver.minigame.bukkit.configs.impl.chat;

import com.daserver.minigame.Minigame;
import com.daserver.minigame.bukkit.configs.AbstractYamlConfiguration;
import com.daserver.minigame.bukkit.configs.exceptions.InvalidFileExtensionException;

import java.io.File;
import java.util.List;

/**
 * This configuration is responsible for chat blacklisted words
 * @see AbstractYamlConfiguration
 */
public class ChatBlacklistConfig extends AbstractYamlConfiguration<ChatBlacklistConfigData> {

    private static ChatBlacklistConfig instance;

    private ChatBlacklistConfig() throws InvalidFileExtensionException {
        super(new File(Minigame.getInstance().getDataFolder(), "chatconfig.yml"));
    }

    public static ChatBlacklistConfig get() {
        if (instance == null) {
            try {
                instance = new ChatBlacklistConfig();
            } catch (InvalidFileExtensionException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public List<String> getBlackListedWords() {
        return getData().getBlackListedWords();
    }

    @Override
    protected ChatBlacklistConfigData getDefaultData() {
        return new ChatBlacklistConfigData();
    }
}
