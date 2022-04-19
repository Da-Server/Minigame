package minigame.minigame.bukkit.game.events.core;

import minigame.minigame.Minigame;
import minigame.minigame.bukkit.game.Game;
import minigame.minigame.bukkit.game.custom.core.GameEndEvent;
import minigame.minigame.bukkit.game.custom.core.GameStartEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GameEventListener implements Listener {


    @EventHandler
    void onGameStart(GameStartEvent evt) {
        Game.start();

        // for testing purposes
        if (evt.isForced()) {
            Minigame.getInstance().getLogger().info("Force started a manhunt game");
        } else Minigame.getInstance().getLogger().info("Started a manhunt game");
    }

    @EventHandler
    void onGameEnd(GameEndEvent evt) {
        Game.end();

        // for testing purposes
        if (evt.isForced()) {
            Minigame.getInstance().getLogger().info("Force started a manhunt game");
        } else Minigame.getInstance().getLogger().info("Started a manhunt game");
    }
}
