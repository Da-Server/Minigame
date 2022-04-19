package minigame.minigame.bukkit.game.events.player.protocol;

import minigame.minigame.Minigame;
import minigame.minigame.bukkit.configs.Config;
import minigame.minigame.bukkit.game.Game;
import minigame.minigame.common.util.formatting.Placeholder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerConnectionListener implements Listener {

    @EventHandler
    void onJoin(PlayerJoinEvent evt) {
        Player player = evt.getPlayer();
        Game.setPlayerCount(Bukkit.getOnlinePlayers().size());
        Minigame.getInstance().getPlayerManager().add(player);
        player.teleport(Minigame.getInstance().getPositionManager().getPre());

        if (Game.isRunning()) {
            player.kickPlayer(Config.GAME_RUNNING_MESSAGE);
            evt.setJoinMessage("");
        } else if(Game.getPlayerCount() > 8) {
            player.kickPlayer(Config.GAME_FULL_MESSAGE);
            evt.setJoinMessage("");
        }

        evt.setJoinMessage(Placeholder.placeholder(0, player, Config.JOIN_MESSAGE));

        for(Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.playSound(onlinePlayer.getLocation(), Config.JOIN_SOUND, 2, 0.1f);
        }
    }

    @EventHandler
    void onLeave(PlayerQuitEvent evt) {
        Player player = evt.getPlayer();
        if(Game.isRunning()) Bukkit.broadcastMessage(Placeholder.placeholder(0, player, Config.QUIT_MESSAGE));
        Minigame.getInstance().getPlayerManager().remove(player);
    }


}
