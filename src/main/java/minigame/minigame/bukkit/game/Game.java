package minigame.minigame.bukkit.game;

import lombok.Getter;
import lombok.Setter;
import minigame.minigame.Minigame;
import minigame.minigame.bukkit.configs.Config;
import minigame.minigame.common.util.SpigotUtil;
import minigame.minigame.common.util.formatting.Placeholder;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class Game {

    @Setter
    private static boolean isRunning = false;

    @Getter
    @Setter
    public static int playerCount = 0;


    private static ArrayList<Player> players = new ArrayList<>();

    public static boolean isRunning() {
        return isRunning;
    }

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
