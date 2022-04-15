package minigame.minigame.bukkit.game.events.player.damage;

import minigame.minigame.bukkit.configs.Config;
import minigame.minigame.common.util.formatting.Placeholder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * A Listener for PlayerDeathEvent
 */
public class PlayerDeathListener implements Listener {

    /**
     * The method for PlayerDeathEvent
     * @param event the event being called
     */
    @EventHandler
    void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        Player killer = null;
        if(player.getKiller() != null) {
            killer = player.getKiller();
            event.setDeathMessage(Placeholder.placeholder(player, killer, Config.PLAYER_DEATH_MESSAGE));
        } else {
            event.setDeathMessage("");
        }
    }
}
