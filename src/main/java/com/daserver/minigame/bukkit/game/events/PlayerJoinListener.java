package com.daserver.minigame.bukkit.game.events;

import com.daserver.minigame.bukkit.configs.Config;
import com.daserver.minigame.bukkit.game.Game;
import com.daserver.minigame.common.util.formatting.Placeholder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        //player.teleport(PositionManager.PRE_GAME);

        if (Game.isRunning())
            player.kickPlayer(Config.GAME_RUNNING_MESSAGE);

        Game.setPlayerCount(Bukkit.getOnlinePlayers().size());

        event.setJoinMessage(Placeholder.placeholder(0, player, Config.JOIN_MESSAGE));

        for(Player onlinePlayer : Bukkit.getOnlinePlayers())
            onlinePlayer.playSound(onlinePlayer.getLocation(), Config.JOIN_SOUND, 2, 0.1f);
    }
}
