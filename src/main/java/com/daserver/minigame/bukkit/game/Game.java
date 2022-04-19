package com.daserver.minigame.bukkit.game;

import lombok.Getter;
import lombok.Setter;
import com.daserver.minigame.Minigame;
import com.daserver.minigame.bukkit.configs.Config;
import com.daserver.minigame.common.util.SpigotUtil;
import com.daserver.minigame.common.util.formatting.Placeholder;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

/**
 * The game manager, responsible for keeping track of what is happening within the game.
 */
public class Game {

    @Setter
    private static boolean isRunning = false;

    @Getter
    @Setter
    public static int playerCount = 0;


    private static ArrayList<Player> players = new ArrayList<>();

    /**
     * Check if the game is currently active
     * @return returns true if this game is active.
     */
    public static boolean isRunning() {
        return isRunning;
    }

    /**
     * Quick event for when the game starts.
     */
    public static void onStart() {
        players.addAll(Bukkit.getOnlinePlayers());
        countDown(10).runTaskTimer(Minigame.instance, 0, 20);

    }
    public static void start() {

    }

    public static void onEnd() {

    }
    public static void end() {

    }


    private static BukkitRunnable countDown(int length) {
        final int[] current = {0};
        return new BukkitRunnable() {
            @Override
            public void run() {
                if(current[0] == length) { cancel(); start(); isRunning = true; }


                for(Player p : Bukkit.getOnlinePlayers()) {
                    Bukkit.broadcastMessage(Placeholder.placeholder(current[0], p, Config.COUNT_DOWN_CHAT));
                    SpigotUtil.sendTitle(p, Placeholder.placeholder(current[0], p, Config.COUNT_DOWN_TITLE), 1,1,1, ChatColor.GOLD);
                }
                current[0]++;
            }
        };
    }
}