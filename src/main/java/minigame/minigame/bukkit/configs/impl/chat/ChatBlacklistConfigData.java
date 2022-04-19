package minigame.minigame.bukkit.configs.impl.chat;

import lombok.Getter;
import lombok.Setter;
import minigame.minigame.bukkit.configs.AbstractYamlConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is the data holder for the Chat blacklist configuration
 * @see ChatBlacklistConfig
 * @see AbstractYamlConfiguration
 */
public class ChatBlacklistConfigData implements ConfigurationSerializable {

    @Getter @Setter private List<String> blackListedWords = new ArrayList<>();

    protected ChatBlacklistConfigData() {
        // defaults
        blackListedWords.add("L");
        blackListedWords.add("Ez");
        blackListedWords.add("fuck");
    }

    @Override
    public Map<String, Object> serialize() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("blackListedWords", blackListedWords);
        return map;
    }
}
