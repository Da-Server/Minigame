package minigame.minigame.bukkit.commands;
import minigame.minigame.bukkit.configs.Config;
import minigame.minigame.bukkit.game.Game;
import minigame.minigame.common.commands.PermissionManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class ForceStart implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player)commandSender;
            if(p.isOp() || p.hasPermission(PermissionManager.FORCE_START)) {
                if(!Game.isRunning()) {
                    Game.onStart();
                    Bukkit.broadcastMessage(Config.FORCE_START_MESSAGE);
                } else {
                    p.sendMessage(Config.RUNNING_MESSAGE);
                    p.playSound(p.getLocation(), Config.ERROR_SOUND, 2, 0.1f);
                }
            }
        }
        return false;
    }
}
