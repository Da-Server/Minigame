package minigame.minigame.bukkit.game.events.player.protocol;

import minigame.minigame.Minigame;
import minigame.minigame.bukkit.configs.Config;
import minigame.minigame.bukkit.game.Game;
import minigame.minigame.common.util.formatting.Placeholder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * A Listener to for the PlayerQuitEvent
 */
public class PlayerQuitListener implements Listener {

    /**
     * The PlayerQuitEventListener
     * @param event the event being called
     */
    @EventHandler
    void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if(Game.isRunning()) Bukkit.broadcastMessage(Placeholder.placeholder(0, player, Config.QUIT_MESSAGE));
        Minigame.getInstance().getPlayerManager().remove(player);
    }
}
