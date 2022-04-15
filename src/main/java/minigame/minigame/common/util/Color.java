package minigame.minigame.common.util;

import org.bukkit.ChatColor;

import java.util.ArrayList;

/**
 * A Color class
 */
public class Color {


    /**
     * Converts a string with '&' into a spigot readable string
     * @param str the input to be changed
     * @return returns the translated input
     */
    public static String colorize(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    /**
     * Converts and arraylist into spigot readable string
     * @param list the input to be converted
     * @return returns the translated list
     */
    public static ArrayList<String> colorizeArrayList(ArrayList<String> list) {
        ArrayList<String> newList = new ArrayList<>();
        list.forEach((str) -> newList.add(colorize(str)));
        return newList;
    }
}
