package minigame.minigame.bukkit.commands;

import minigame.minigame.bukkit.configs.Config;
import minigame.minigame.bukkit.game.Game;
import minigame.minigame.bukkit.game.custom.core.GameEndEvent;
import minigame.minigame.common.commands.PermissionManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ForceEnd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player)commandSender;
            if(p.isOp() || p.hasPermission(PermissionManager.FORCE_END)) {
                if(Game.isRunning()) {
                    Bukkit.getPluginManager().callEvent(new GameEndEvent(true));
                    Bukkit.broadcastMessage(Config.FORCE_END_MESSAGE);
                } else {
                    p.sendMessage(Config.NOT_RUNNING_MESSAGE);
                    p.playSound(p.getLocation(), Config.ERROR_SOUND, 2, 0.1f);
                }
            }
        }
        return false;
    }
}
