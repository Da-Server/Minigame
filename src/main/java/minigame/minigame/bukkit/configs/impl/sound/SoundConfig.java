package minigame.minigame.bukkit.configs.impl.sound;

import minigame.minigame.Minigame;
import minigame.minigame.bukkit.configs.AbstractYamlConfiguration;
import minigame.minigame.bukkit.configs.exceptions.InvalidFileExtensionException;

import java.io.File;

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
