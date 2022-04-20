package com.daserver.minigame.bukkit.configs.impl.sound;

import com.daserver.minigame.bukkit.configs.AbstractYamlConfiguration;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Sound;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a data holder for the sound configuration
 * @see SoundConfig
 * @see AbstractYamlConfiguration
 */
@Getter
@Setter
public class SoundConfigData implements ConfigurationSerializable {

    private Sound joinSound, countSound, startSound, guiClickSound, errorSound;

    protected SoundConfigData() {
        // defaults
        this.joinSound = Sound.CHICKEN_EGG_POP;
        this.countSound = Sound.NOTE_STICKS;
        this.startSound = Sound.NOTE_PLING;
        this.guiClickSound = Sound.NOTE_PLING;
        this.errorSound = Sound.ENDERMAN_TELEPORT;
    }

    @Override
    public Map<String, Object> serialize() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("join_sound", joinSound);
        map.put("count_sound", countSound);
        map.put("start_sound", startSound);
        map.put("gui_click_sound", guiClickSound);
        map.put("error_sound", errorSound);
        return map;
    }
}
