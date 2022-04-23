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
public class SoundConfigData implements ConfigurationSerializable {

    private String joinSound, countSound, startSound, guiClickSound, errorSound;

    protected SoundConfigData() {
        // defaults
        this.joinSound = Sound.CHICKEN_EGG_POP.name();
        this.countSound = Sound.NOTE_STICKS.name();
        this.startSound = Sound.NOTE_PLING.name();
        this.guiClickSound = Sound.NOTE_PLING.name();
        this.errorSound = Sound.ENDERMAN_TELEPORT.name();
    }

    /**
     * Parses Sound from a string
     * @param name string value
     * @return Sound from string
     */
    private Sound parse(String name) {
        return Sound.valueOf(name);
    }


    public Sound getCountSound() {
        return parse(countSound);
    }
    public Sound getErrorSound() {
        return parse(errorSound);
    }
    public Sound getGuiClickSound() {
        return parse(guiClickSound);
    }
    public Sound getJoinSound() {
        return parse(joinSound);
    }
    public Sound getStartSound() {
        return parse(startSound);
    }

    public void setCountSound(Sound countSound) {
        this.countSound = countSound.name();
    }
    public void setErrorSound(Sound errorSound) {
        this.errorSound = errorSound.name();
    }
    public void setGuiClickSound(Sound guiClickSound) {
        this.guiClickSound = guiClickSound.name();
    }
    public void setJoinSound(Sound joinSound) {
        this.joinSound = joinSound.name();
    }
    public void setStartSound(Sound startSound) {
        this.startSound = startSound.name();
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
