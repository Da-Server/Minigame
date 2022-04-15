package minigame.minigame.bukkit.game.events;

import minigame.minigame.bukkit.configs.Config;
import minigame.minigame.bukkit.game.Game;
import minigame.minigame.common.util.formatting.Placeholder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    void onQuit(PlayerQuitEvent event) {
        if(Game.isRunning()) Bukkit.broadcastMessage(Placeholder.placeholder(0, event.getPlayer(), Config.QUIT_MESSAGE));
        else event.setQuitMessage("");
    }
}
