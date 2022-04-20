package com.daserver.minigame.bukkit.commands;

import com.daserver.minigame.bukkit.configs.impl.chat.placeholders.ChatPlaceHoldersConfig;
import com.daserver.minigame.bukkit.configs.impl.sound.SoundConfig;
import com.daserver.minigame.bukkit.game.Game;
import com.daserver.minigame.bukkit.game.custom.core.GameEndEvent;
import com.daserver.minigame.common.commands.PermissionManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * An in-game command related to {@link Game}
 * Used to force end a game, Requires minigame.forceend permission
 */
public class ForceEnd implements CommandExecutor {

    private final ChatPlaceHoldersConfig placeHolders = ChatPlaceHoldersConfig.get();
    private final SoundConfig soundConfig = SoundConfig.get();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player)commandSender;
            if(p.isOp() || p.hasPermission(PermissionManager.FORCE_END)) {
                if(Game.isRunning()) {
                    Bukkit.getPluginManager().callEvent(new GameEndEvent(true));
                    Bukkit.broadcastMessage(placeHolders.getData().getForceEndMessage());
                } else {
                    p.sendMessage(placeHolders.getData().getNotRunningMessage());
                    p.playSound(p.getLocation(), soundConfig.getData().getErrorSound(), 2, 0.1f);
                }
            }
        }
        return false;
    }
}
