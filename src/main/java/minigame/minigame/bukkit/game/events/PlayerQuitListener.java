package minigame.minigame.bukkit.game.events;

import minigame.minigame.bukkit.configs.Config;
import minigame.minigame.bukkit.game.Game;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    void onQuit(PlayerQuitEvent event) {
        if(Game.isRunning()) Bukkit.broadcastMessage(Config.QUIT_MESSAGE);
    }
}
