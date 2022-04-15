package minigame.minigame.common.util.formatting;

import minigame.minigame.bukkit.game.Game;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Placeholder {

    private static final HashMap<String, String> placeholders = new HashMap<String, String>() {

    };


    public static String placeholder(Player player, String in) {
        in.replace("%PLAYER_NAME%", player.getName());
        in.replace("%PLAYER_COUNT%", String.valueOf(Game.getPlayerCount()));
        for(String s : placeholders.keySet()) {
            in.replace("%" + s + "%", placeholders.get(s));
        }
        return in;
    }

}
