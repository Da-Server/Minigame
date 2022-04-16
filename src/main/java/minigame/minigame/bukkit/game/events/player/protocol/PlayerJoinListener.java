package minigame.minigame.bukkit.game.events.player.protocol;

import minigame.minigame.Minigame;
import minigame.minigame.bukkit.configs.Config;
import minigame.minigame.bukkit.game.Game;
import minigame.minigame.bukkit.position.PositionManager;
import minigame.minigame.common.util.formatting.Placeholder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * The Listener for PlayerJoinEvent
 */
public class PlayerJoinListener implements Listener {

    /**
     * The method for the event PlayerJoinEvent
     * @param event the event being called
     */
    @EventHandler
    void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Game.setPlayerCount(Bukkit.getOnlinePlayers().size());
        Minigame.getInstance().getPlayerManager().add(player);
        player.teleport(Minigame.getInstance().getPositionManager().getPre());

        if (Game.isRunning()) {
            player.kickPlayer(Config.GAME_RUNNING_MESSAGE);
            event.setJoinMessage("");
        } else if(Game.getPlayerCount() > 8) {
            player.kickPlayer(Config.GAME_FULL_MESSAGE);
            event.setJoinMessage("");
        }


        event.setJoinMessage(Placeholder.placeholder(0, player, Config.JOIN_MESSAGE));



        for(Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.playSound(onlinePlayer.getLocation(), Config.JOIN_SOUND, 2, 0.1f);
        }
    }
}
