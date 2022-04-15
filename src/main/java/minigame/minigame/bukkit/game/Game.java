package minigame.minigame.bukkit.game;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

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

    }
}
