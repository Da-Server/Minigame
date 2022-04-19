package minigame.minigame.bukkit.commands;

import minigame.minigame.bukkit.configs.Config;
import minigame.minigame.bukkit.game.Game;
import minigame.minigame.bukkit.game.custom.core.GameStartEvent;
import minigame.minigame.bukkit.gui.guis.shop.ShopGUI;
import minigame.minigame.common.commands.PermissionManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpenShop implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player)commandSender;
            if(p.isOp()) {
                p.openInventory(new ShopGUI("shop") {@Override public int shopSlot() { return 0; }@Override public Material icon() { return null; }}.getInventory());
            }
        }
        return false;
    }
}
