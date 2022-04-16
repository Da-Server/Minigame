package minigame.minigame.bukkit.game.events.player.damage;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * A Listener for EntityDamageByEntityEvent
 */
public class PlayerDamageByPlayerListener implements Listener {

    /**
     * The method for EntityDamageByEntityEvent
     * @param event the event being called
     */
    @EventHandler
    void onPlayerDamageByPlayer(EntityDamageByEntityEvent event) {
        if(event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if(event.getDamager() instanceof Player) {
                Player damager = (Player) event.getDamager();

                //Do stuff
            }
        }
    }
}
