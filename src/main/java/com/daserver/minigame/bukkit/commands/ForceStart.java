package com.daserver.minigame.bukkit.commands;
import com.daserver.minigame.bukkit.configs.Config;
import com.daserver.minigame.bukkit.game.Game;
import com.daserver.minigame.common.commands.PermissionManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ForceStart implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player)commandSender;
            if(p.isOp() || p.hasPermission(PermissionManager.FORCE_START)) {
                Game.onStart();
                Bukkit.broadcastMessage(Config.FORCE_START_MESSAGE);
            }
        }
        return false;
    }
}
