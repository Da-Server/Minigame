package com.daserver.minigame.bukkit.game.events.core;

import com.daserver.minigame.Minigame;
import com.daserver.minigame.bukkit.game.Game;
import com.daserver.minigame.bukkit.game.custom.core.GameEndEvent;
import com.daserver.minigame.bukkit.game.custom.core.GameStartEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GameEventListener implements Listener {


    @EventHandler
    void onGameStart(GameStartEvent event) {
        Game.start();

        // for testing purposes
        if (event.isForced()) {
            Minigame.getInstance().getLogger().info("Force started a manhunt game");
        } else Minigame.getInstance().getLogger().info("Started a manhunt game");
    }

    @EventHandler
    void onGameEnd(GameEndEvent event) {
        Game.end();

        // for testing purposes
        if (event.isForced()) {
            Minigame.getInstance().getLogger().info("Force started a manhunt game");
        } else Minigame.getInstance().getLogger().info("Started a manhunt game");
    }
}
