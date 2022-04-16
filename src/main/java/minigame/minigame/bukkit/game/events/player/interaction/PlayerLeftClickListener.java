package minigame.minigame.bukkit.game.events.player.interaction;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * A Listener for PlayerInteractEvent
 */
public class PlayerLeftClickListener implements Listener {

    @EventHandler
    void onLeftClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
            ItemStack i = event.getItem();
            if(i != null) {

            }
        }
    }
}
