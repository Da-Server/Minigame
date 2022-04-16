package minigame.minigame.bukkit.configs;

import minigame.minigame.common.util.Color;
import org.bukkit.Sound;

/**
 * DataModel class for holding data contained within the config file.
 */
public class Config {

    public static final String GAME_RUNNING_MESSAGE = Color.colorize("&cYou can not join while a game is running!");
    public static final String JOIN_MESSAGE = Color.colorize("&6${PLAYER_NAME} &7Has joined we now have ${PLAYER_COUNT}/8 Players.");
    public static final String QUIT_MESSAGE = Color.colorize("&c${PLAYER_NAME} &7Has left the game!");
    public static final String COUNT_DOWN_CHAT = Color.colorize("&6${COUNT_DOWN_NUMBER_ROMAN} Seconds &7Left!");
    public static final String FORCE_START_MESSAGE = Color.colorize("&cThe Game Has been Force Started!");
    public static final String FORCE_END_MESSAGE = Color.colorize("&cThe Game Has been Force Ended!");
    public static final String GAME_FULL_MESSAGE = Color.colorize("&6GAME FULL!");
    public static final String GAVE_ITEM_MESSAGE = Color.colorize("&aGave you ${ITEM}");
    public static final String NOT_RUNNING_MESSAGE = Color.colorize("&cThere is no game running at this moment.");
    public static final String RUNNING_MESSAGE = Color.colorize("&cThere is a game already running.");

    public static final String PLAYER_DEATH_MESSAGE = Color.colorize("&c${KILLER} Has Killed ${VICTIM}");



    public static final String COUNT_DOWN_TITLE = "${COUNT_DOWN_NUMBER_ROMAN}";
    public static final String GAME_START_TITLE = "THE GAME BEINGS!";
    public static final String VICTORY_TITLE = "Victory!!!";
    public static final String GAME_OVER_TITLE = "Game Over.";

    public static final Sound JOIN_SOUND = Sound.CHICKEN_EGG_POP;
    public static final Sound COUNT_SOUND = Sound.NOTE_STICKS;
    public static final Sound START_SOUND = Sound.NOTE_PLING;
    public static final Sound GUI_CLICK_SOUND = Sound.NOTE_PLING;
    public static final Sound ERROR_SOUND = Sound.ENDERMAN_TELEPORT;


}
