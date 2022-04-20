package com.daserver.minigame.bukkit.configs.impl.chat.placeholders;

import com.daserver.minigame.common.util.Color;
import lombok.Getter;
import lombok.Setter;
import com.daserver.minigame.bukkit.configs.AbstractYamlConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is a data holder for the Chat Placeholders configuration
 * @see ChatPlaceHoldersConfig
 * @see AbstractYamlConfiguration
 */
@Getter
@Setter
public class ChatPlaceHoldersConfigData implements ConfigurationSerializable {

    private String gameRunningMessage, joinMessage, quitMessage, countDownChat, forceStartMessage,
            forceEndMessage, fullGameMessage, gaveItemMessage, notRunningMessage, runningMessage,
            playerDeathMessage, countDownTitle, gameStartTitle, victoryTitle, gameOverTitle;

    protected ChatPlaceHoldersConfigData() {
        gameRunningMessage = Color.colorize("&cYou can not join while a game is running!");
        joinMessage = Color.colorize("&6${PLAYER_NAME} &7Has joined we now have ${PLAYER_COUNT}/8 Players.");
        quitMessage = Color.colorize("&c${PLAYER_NAME} &7Has left the game!");
        countDownChat = Color.colorize("&6${COUNT_DOWN_NUMBER_ROMAN} Seconds &7Left!");
        forceStartMessage = Color.colorize("&cThe Game Has been Force Started!");
        forceEndMessage = Color.colorize("&cThe Game Has been Force Ended!");
        fullGameMessage = Color.colorize("&6GAME FULL!");
        gaveItemMessage = Color.colorize("&aGave you ${ITEM}");
        notRunningMessage = Color.colorize("&cThere is no game running at this moment.");
        runningMessage = Color.colorize("&cThere is a game already running.");
        playerDeathMessage = Color.colorize("&c${KILLER} Has Killed ${VICTIM}");

        countDownTitle = "${COUNT_DOWN_NUMBER_ROMAN}";
        gameStartTitle = "THE GAME BEINGS!";
        victoryTitle = "Victory!!!";
        gameOverTitle = "Game Over.";
    }

    @Override
    public Map<String, Object> serialize() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("game_running_message", gameRunningMessage);
        map.put("join_message", joinMessage);
        map.put("quit_message", quitMessage);
        map.put("count_down_chat", countDownChat);
        map.put("force_start_message", forceStartMessage);
        map.put("force_end_message", forceEndMessage);
        map.put("full_game_message", fullGameMessage);
        map.put("gave_item_message", gaveItemMessage);
        map.put("not_running_message", notRunningMessage);
        map.put("running_message", runningMessage);
        map.put("player_death_message", playerDeathMessage);

        map.put("count_down_title", countDownTitle);
        map.put("game_start_title", gameStartTitle);
        map.put("victory_title", victoryTitle);
        map.put("game_over_title", gameOverTitle);
        return map;
    }
}
