package minigame.minigame.bukkit.game.events.entity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

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
        Entity entity = event.getEntity();
        EntityType entityType = event.getEntityType();

    }
}
