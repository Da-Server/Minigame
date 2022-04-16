package minigame.minigame.bukkit.game;

import lombok.Getter;
import lombok.Setter;
import minigame.minigame.Minigame;
import minigame.minigame.bukkit.configs.Config;
import minigame.minigame.common.players.PlayerManager;
import minigame.minigame.common.util.SpigotUtil;
import minigame.minigame.common.util.formatting.Placeholder;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

/**
 * The game manager, responsible for keeping track of what is happening within the game.
 */
public class Game {

    @Setter
    private static boolean isRunning = false;

    @Getter
    private static PlayerManager playerManager;

    @Getter
    private static Game game = new Game();

    @Getter
    @Setter
    public static int playerCount = 0;

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
        playerManager = Minigame.getInstance().getPlayerManager();
        countDown(10).runTaskTimer(Minigame.getInstance(), 0, 20);

    }
    public static void start() {
        isRunning = true;
        game.broadcastSound(Config.START_SOUND, 2,2f);

        game.broadcastTitle(Config.GAME_START_TITLE, 20, 20, 20, ChatColor.GREEN);
    }

    public static void onEnd() {
        end();
        isRunning = false;
    }
    public static void end() {
        playerManager.getPlayerList().forEach((player) -> {
            player.setGameMode(GameMode.ADVENTURE);
            player.getInventory().clear();
        });

        Player victor = playerManager.getLivingPlayers().get(0);

        for(Player p : playerManager.getDeadPlayers()) {
            SpigotUtil.sendTitle(p, Config.GAME_OVER_TITLE, 20, 20, 20, ChatColor.RED);
        }
        SpigotUtil.sendTitle(victor, Config.VICTORY_TITLE, 20, 20, 20, ChatColor.GOLD);
        new BukkitRunnable() {
            int d = 0;
            @Override
            public void run() {
                if(d >= 10) {
                    cancel();
                }

                Entity firework = Minigame.getInstance().getWorld().spawnEntity(SpigotUtil.getRandomLocation(victor, 10, 4, false), EntityType.FIREWORK);
                FireworkMeta meta = ((Firework)firework).getFireworkMeta();
                meta.setPower(1);
                meta.addEffects(FireworkEffect.builder().flicker(true).trail(true).withColor(Color.RED).build());
                ((Firework) firework).setFireworkMeta(meta);
                firework.teleport(SpigotUtil.getRandomLocation(victor, 10, 4, false));
                d++;
            }
        }.runTaskTimer(Minigame.getInstance(), 0, 20);
    }


    private static BukkitRunnable countDown(int length) {
        final int[] current = {0};
        return new BukkitRunnable() {
            @Override
            public void run() {
                if(current[0] == length) {
                    cancel();
                    start();

                }
                if(current[0] - length != 0) {
                    Bukkit.broadcastMessage(Placeholder.placeholder(length - current[0], Minigame.getInstance().getPlayerManager().getPlayerList().get(0), Config.COUNT_DOWN_CHAT));
                    game.broadcastTitle(Placeholder.placeholder(length - current[0], Minigame.getInstance().getPlayerManager().getPlayerList().get(0), Config.COUNT_DOWN_TITLE), 20, 20, 20, ChatColor.GOLD);
                    game.broadcastSound(Config.COUNT_SOUND, 2, 2);
                }
                current[0]++;
            }
        };
    }

    private void broadcastSound(Sound sound, float volume, float pitch) {
        Minigame.getInstance().getPlayerManager().getPlayerList().forEach((p) -> p.playSound(p.getLocation(), sound,volume,pitch));
    }
    private void broadcastTitle(String s, int i, int j, int k, ChatColor color) {
        Minigame.getInstance().getPlayerManager().getPlayerList().forEach((p) -> SpigotUtil.sendTitle(p, s, i,j,k, color));
    }
}
