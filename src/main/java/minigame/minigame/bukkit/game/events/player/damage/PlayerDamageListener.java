package minigame.minigame.bukkit.game.events.player.damage;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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

        if(event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            double damage = event.getDamage();
            double finalDamage = event.getFinalDamage();
            DamageCause cause = event.getCause();


        }
    }
}
