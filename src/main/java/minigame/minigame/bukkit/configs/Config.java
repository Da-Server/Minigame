package minigame.minigame.bukkit.configs;

import minigame.minigame.common.util.Color;
import org.bukkit.Sound;

/**
 * DataModel class for holding data contained within the config file.
 */
public class Config {

    public static final String GAME_RUNNING_MESSAGE = Color.colorize("&cYou can not join while a game is running!");
    public static final String JOIN_MESSAGE = Color.colorize("&6%PLAYER_NAME% &7Has joined we now have %PLAYER_COUNT%/8 Players.");
    public static final String QUIT_MESSAGE = Color.colorize("&c%PLAYER_NAME% &7Has left the game!");

    public static final Sound JOIN_SOUND = Sound.CHICKEN_EGG_POP;


}
