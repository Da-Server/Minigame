package com.daserver.minigame.bukkit.commands;

import com.daserver.minigame.bukkit.gui.guis.ItemGUI;
import com.daserver.minigame.common.commands.PermissionManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CI implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player)commandSender;
            if(p.isOp() || p.hasPermission(PermissionManager.CUSTOM_ITEM)) {
                p.openInventory(new ItemGUI().getInventory());
            }
        }
        return false;
    }
}
