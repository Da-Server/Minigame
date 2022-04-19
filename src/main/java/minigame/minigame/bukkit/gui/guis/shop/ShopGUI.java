package minigame.minigame.bukkit.gui.guis.shop;

import minigame.minigame.Minigame;
import minigame.minigame.bukkit.configs.Config;
import minigame.minigame.bukkit.gui.Gui;
import minigame.minigame.bukkit.gui.components.MenuGlass;
import minigame.minigame.bukkit.item.ItemManager;
import minigame.minigame.common.points.PlayerStats;
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
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class ShopGUI extends Gui implements Listener {

    private HashMap<ItemStack, Integer> items = new HashMap <>();
    private HashMap<ShopGUI, Integer> guis = new HashMap <>();
    private HashMap<Integer, ShopGUI> guisSlots = new HashMap <>();
    private HashMap<ItemStack, ItemStack> itemMap = new HashMap <>();
    private int currentItemSlot = 0;
    /**
     * Initializes the GUI
     */
    public ShopGUI(String name) {
        super("&c" + name, Gui.MAX_SIZE);
        fill(MenuGlass.WHITE.build());
        ring(MenuGlass.ORANGE.build());
        guis.put(this, shopSlot());
        guisSlots.put(shopSlot(), this);

        setItem(shopSlot(), ItemManager.buildItem("&6&l" + getName(), icon(), true));

    }

    public void addItem(ItemStack i) {
        if(currentItemSlot % 9 == 0) {
            currentItemSlot++;
        } else if(currentItemSlot % 8 == 0) {
            currentItemSlot++;
        }
        ItemStack finalI = i.clone();
        ItemMeta m = i.getItemMeta();
        List <String> lore = m.getLore();
        lore.add("");
        lore.add("&6This item costs: &a" + ItemManager.getPurchasable().get(i) + " Points.");
        lore = Color.colorizeArrayList((ArrayList <String>) lore);
        m.setLore(lore);
        i.setItemMeta(m);
        itemMap.put(i, finalI);
        items.put(i, currentItemSlot);
        setItem(currentItemSlot, i);
        currentItemSlot++;
    }

    public abstract int shopSlot();
    public abstract Material icon();


    @EventHandler
    void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack currentItem = event.getCurrentItem();
        Inventory clicked = event.getClickedInventory();
        InventoryView view = event.getView();
        String title = Color.colorize(view.getTitle());
        PlayerStats playerStats = Minigame.getInstance().getPlayerManager().getPlayerStats(player);
        if(this.equals(view, clicked)) {
            event.setCancelled(true);
            if(this.guis.containsValue(event.getRawSlot())) {
                player.openInventory(guisSlots.get(event.getRawSlot()).getInventory());
            } else {
                for (ItemStack i: ItemManager.getPurchasable().keySet()) {
                    if (itemMap.get(currentItem) == i) {
                        if (playerStats.getPoints() >= ItemManager.getPurchasable().get(i)) {
                            player.getInventory().addItem(currentItem);
                            playerStats.subtractPoints(ItemManager.getPurchasable().get(i));
                            player.playSound(player.getLocation(), Config.GUI_CLICK_SOUND, 2, 2);
                            break;
                        }
                    }
                }
            }


        }
    }
}
