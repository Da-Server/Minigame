package minigame.minigame.bukkit.gui.guis.shop.upgrades;

import minigame.minigame.bukkit.gui.guis.shop.ShopGUI;
import org.bukkit.Material;

public class UpgradesGUI extends ShopGUI {
    /**
     * Initializes the GUI
     */
    public UpgradesGUI() {
        super("Upgrades");
    }

    @Override
    public int shopSlot() {
        return 7;
    }

    @Override
    public Material icon() {
        return Material.LAVA_BUCKET;
    }
}
