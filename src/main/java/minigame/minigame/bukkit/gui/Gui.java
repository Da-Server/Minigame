package minigame.minigame.bukkit.gui;

import lombok.Getter;
import minigame.minigame.common.util.Color;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class Gui implements InventoryHolder {

    /**
     * MAX Inventory SIZE
     */
    public static final int MAX_SIZE = 54;

    @Getter
    private Inventory inv;
    private int size = 0;
    private String name = "";

    /**
     * Initializes the GUI
     * @param name sets the gui's name
     * @param size sets the gui's size
     */
    public Gui(String name, int size) {
        inv = Bukkit.createInventory(this, size, Color.colorize(name));
        this.size = size;
    }

    /**
     * Fills the ui with an item
     * @param i The item to fill the ui with
     */
    public void fill(ItemStack i) {
        for(int j = 0; j < this.size; j++) {
            inv.setItem(j, i);
        }
    }

    /**
     * Creates A Ring around the ui
     * @param i the item used to ring the ui
     */
    public void ring(ItemStack i) {
        for(int j = 0; j < size; j++) {
            if(j < 8) {
                inv.setItem(j, i);
            } else if(j % 8 == 0 && j < (size - 9)) {
                inv.setItem(j, i);
            } else if(j % 9 == 0) {
                inv.setItem(j, i);
            }
        }
    }


    /**
     *
     * @return returns the inventory of the gui
     */
    @Override
    public Inventory getInventory() {
        return inv;
    }
}
