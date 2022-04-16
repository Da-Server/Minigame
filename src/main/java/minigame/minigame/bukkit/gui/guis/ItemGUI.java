package minigame.minigame.bukkit.gui.guis;

import minigame.minigame.bukkit.configs.Config;
import minigame.minigame.bukkit.gui.Gui;
import minigame.minigame.bukkit.gui.components.MenuGlass;
import minigame.minigame.bukkit.item.CItem;
import minigame.minigame.bukkit.item.ItemManager;
import minigame.minigame.common.util.Color;
import minigame.minigame.common.util.formatting.Placeholder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class ItemGUI extends Gui implements Listener {
    /**
     * Initializes the GUI
     */
    public ItemGUI() {
        super("&cCustom Items", 54);
        fill(MenuGlass.BLACK.build());
        int i = 0;
        for(ItemStack item : ItemManager.getItemMap().values()) {
            setItem(i, item);
            i++;
        }
    }

    @EventHandler
    void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack currentItem = event.getCurrentItem();
        Inventory clicked = event.getClickedInventory();
        InventoryView view = event.getView();
        String title = Color.colorize(view.getTitle());
        if(this.equals(view, clicked)) {
            event.setCancelled(true);
            for(ItemStack i : ItemManager.getItemMap().values()) {
                if(currentItem.equals(i)) {
                    player.getInventory().addItem(currentItem);
                    player.sendMessage(Placeholder.placeholder(currentItem, player, Config.GAVE_ITEM_MESSAGE));
                    player.playSound(player.getLocation(), Config.GUI_CLICK_SOUND, 2, 2);
                }
            }
        }
    }
}
