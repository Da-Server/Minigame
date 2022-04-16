package minigame.minigame.bukkit.game.events.player.damage;

import minigame.minigame.Minigame;
import minigame.minigame.bukkit.configs.Config;
import minigame.minigame.bukkit.game.Game;
import minigame.minigame.common.players.PlayerManager;
import minigame.minigame.common.points.PlayerStats;
import minigame.minigame.common.util.formatting.Placeholder;
import org.bukkit.GameMode;
import org.bukkit.Material;
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
            event.setDeathMessage("");
        }
    }
}
