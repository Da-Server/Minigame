package minigame.minigame.bukkit.gui.guis.shop.shops;

import minigame.minigame.bukkit.gui.guis.shop.ShopGUI;
import minigame.minigame.bukkit.item.ItemManager;
import org.bukkit.Material;

public class WeaponShopGUI extends ShopGUI {
    /**
     * Initializes the GUI
     */
    public WeaponShopGUI() {
        super("Weapons");
        addItem(ItemManager.getItem("STEEL_DAGGER"));
    }

    @Override
    public int shopSlot() {
        return 1;
    }

    @Override
    public Material icon() {
        return Material.IRON_SWORD;
    }
}
