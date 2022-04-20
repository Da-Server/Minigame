package com.daserver.minigame.bukkit.game.events.player.interaction;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * A listener for player left click and right click interaction events
 */
public class PlayerInteractionListener implements Listener {

    /**
     * The listener method for {@link PlayerInteractEvent}
     * @param event the event
     */
    @EventHandler
    void onInteract(PlayerInteractEvent event) {
        // left click
        ItemStack interactionItem = event.getItem();
        if (interactionItem == null) return;
        if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
            // code for interaction as left click
        } else if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            // code for interaction as right click
        }

    }
}
