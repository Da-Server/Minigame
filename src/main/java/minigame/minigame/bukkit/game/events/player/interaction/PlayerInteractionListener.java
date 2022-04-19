package minigame.minigame.bukkit.game.events.player.interaction;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractionListener implements Listener {

    @EventHandler
    void onInteract(PlayerInteractEvent evt) {
        // left click
        ItemStack interactionItem = evt.getItem();
        if (interactionItem == null) return;
        if(evt.getAction() == Action.LEFT_CLICK_AIR || evt.getAction() == Action.LEFT_CLICK_BLOCK) {
            // code for interaction as left click
        } else if (evt.getAction() == Action.RIGHT_CLICK_AIR || evt.getAction() == Action.RIGHT_CLICK_BLOCK) {
            // code for interaction as right click
        }

    }
}
