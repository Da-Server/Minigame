package com.daserver.minigame.bukkit.game.events.entity;

import com.daserver.minigame.Minigame;
import com.daserver.minigame.bukkit.configs.impl.chat.placeholders.ChatPlaceHoldersConfig;
import com.daserver.minigame.bukkit.game.Game;
import com.daserver.minigame.common.players.PlayerManager;
import com.daserver.minigame.common.points.PlayerStats;
import com.daserver.minigame.common.util.formatting.Placeholder;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * A Listener for EntityDeathEvent
 */
public class EntityDeathListener implements Listener {

    /**
     * The Method for EntityDeathEvent
     * @param event the event being called
     */
    @EventHandler
    void onDeathEvent(EntityDeathEvent event) {

        if (event instanceof PlayerDeathEvent playerEvent) {
            // code for player death event
            Player player = playerEvent.getEntity();
            Player killer = player.getKiller();

            if(player.getKiller() != null) {
                playerEvent.setDeathMessage(Placeholder.placeholder(player, killer, ChatPlaceHoldersConfig.get().getData().getPlayerDeathMessage()));
                if(Game.isRunning()) {
                    PlayerStats stats = Minigame.getInstance().getPlayerManager().getPlayerStats(player);
                    PlayerManager manager = Minigame.getInstance().getPlayerManager();
                    if (!stats.hasBeacon()) {
                        manager.setDead(player);
                        player.setGameMode(GameMode.SPECTATOR);
                    }
                    PlayerStats killerStats = manager.getPlayerStats(killer);
                    if(killer.getItemInHand().getType() == Material.BOW) {
                        killerStats.addPoints(1);
                    } else {
                        killerStats.addPoints(2);
                    }

                    if(killerStats.getPoints() == 5) {
                        //the items
                    }
                }

            } else {
                playerEvent.setDeathMessage("");
            }
        }
        // additional code may be added here to check for entity generic death event
    }
}
