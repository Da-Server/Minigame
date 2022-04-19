package minigame.minigame.bukkit.game.events.player.damage;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

/**
 * A Listener for the EntityDamageEvent
 */
public class PlayerDamageListener implements Listener {

    /**
     * The method for EntityDamageEvent
     * @param event the event that is being called
     */
    @EventHandler
    void onPlayerDamage(EntityDamageEvent event) {
        Entity damagedEntity = event.getEntity();

        if (event instanceof EntityDamageByEntityEvent byEntity) {
            if (!(damagedEntity instanceof Player victim)) return;
            if (!(byEntity.getDamager() instanceof Player attacker)) return;
            // add code for player damage by player

        }

        // additional code may be added here to check for generic damage event

    }
}
