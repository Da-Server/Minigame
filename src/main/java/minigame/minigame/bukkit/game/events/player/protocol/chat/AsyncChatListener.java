package minigame.minigame.bukkit.game.events.player.protocol.chat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * A Listener for AsyncPlayerChatEvent
 */
public class AsyncChatListener implements Listener {
    /**
     * The method for AsyncPlayerChatEvent
     * @param event the event being called
     */
    @EventHandler
    void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String msg = event.getMessage();
    }
}
