package minigame.minigame.util;

import org.bukkit.ChatColor;

public class Color {

    public static String colorize(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
