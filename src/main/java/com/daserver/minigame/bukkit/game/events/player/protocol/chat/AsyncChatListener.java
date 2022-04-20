package com.daserver.minigame.bukkit.game.events.player.protocol.chat;

import com.daserver.minigame.common.util.Color;
import com.daserver.minigame.bukkit.configs.impl.chat.ChatBlacklistConfig;
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

        for(String s : ChatBlacklistConfig.get().getBlackListedWords()) {
            if(msg.contains(s)) {
                event.setCancelled(true);
                player.sendMessage(Color.colorize("&cNaughty don't do that!"));
            }
        }
    }
}
