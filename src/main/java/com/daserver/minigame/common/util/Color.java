package com.daserver.minigame.common.util;

import org.bukkit.ChatColor;

import java.util.ArrayList;

public class Color {

    public static String colorize(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public static ArrayList<String> colorizeArrayList(ArrayList<String> list) {
        ArrayList<String> newList = new ArrayList<>();
        list.forEach((str) -> newList.add(colorize(str)));
        return newList;
    }
}
