package minigame.minigame.bukkit.game.events.player.protocol.chat;

import minigame.minigame.bukkit.configs.ChatConfig;
import minigame.minigame.common.util.Color;
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

        for(String s : ChatConfig.blacklisted) {
            if(msg.contains(s)) {
                event.setCancelled(true);
                player.sendMessage(Color.colorize("&cNaughty don't do that!"));
            }
        }
    }
}
