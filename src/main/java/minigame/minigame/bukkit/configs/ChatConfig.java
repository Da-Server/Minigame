package minigame.minigame.bukkit.configs;

import java.util.ArrayList;

/**
 * A Configuration file for chat messages
 */
public class ChatConfig {

    public static final ArrayList<String> blacklisted = new ArrayList <String>();
    static {
        blacklisted.add("ez");
        blacklisted.add("Ez");
        blacklisted.add("eZ");
        blacklisted.add("EZ");
        blacklisted.add("l");
        blacklisted.add("L");
    }

}
