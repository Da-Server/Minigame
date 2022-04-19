package minigame.minigame.bukkit.game.events.player.protocol;

import minigame.minigame.Minigame;
import minigame.minigame.bukkit.configs.impl.chat.placeholders.ChatPlaceHoldersConfig;
import minigame.minigame.bukkit.configs.impl.sound.SoundConfig;
import minigame.minigame.bukkit.game.Game;
import minigame.minigame.common.util.formatting.Placeholder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * A listener for player join/leave events
 */
public class PlayerConnectionListener implements Listener {

    private final ChatPlaceHoldersConfig placeHoldersConfig = ChatPlaceHoldersConfig.get();
    private final SoundConfig soundConfig = SoundConfig.get();

    /**
     * The method for {@link PlayerJoinEvent}
     * @param event the event
     */
    @EventHandler
    void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Game.setPlayerCount(Bukkit.getOnlinePlayers().size());
        Minigame.getInstance().getPlayerManager().add(player);
        player.teleport(Minigame.getInstance().getPositionManager().getPre());

        if (Game.isRunning()) {
            player.kickPlayer(placeHoldersConfig.getData().getGameRunningMessage());
            event.setJoinMessage("");
        } else if(Game.getPlayerCount() > 8) {
            player.kickPlayer(placeHoldersConfig.getData().getFullGameMessage());
            event.setJoinMessage("");
        }

        event.setJoinMessage(Placeholder.placeholder(0, player, placeHoldersConfig.getData().getJoinMessage()));

        for(Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.playSound(onlinePlayer.getLocation(), soundConfig.getData().getJoinSound(), 2, 0.1f);
        }
    }

    /**
     * The method for {@link PlayerQuitEvent}
     * @param event the event
     */
    @EventHandler
    void onLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if(Game.isRunning()) Bukkit.broadcastMessage(Placeholder.placeholder(0, player, placeHoldersConfig.getData().getQuitMessage()));
        Minigame.getInstance().getPlayerManager().remove(player);
    }


}
