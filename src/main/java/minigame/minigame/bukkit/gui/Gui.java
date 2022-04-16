package minigame.minigame.bukkit.gui;

import lombok.Getter;
import minigame.minigame.common.util.Color;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

/**
 * A Custom InventoryHolder for gui's
 * TODO: Add a gui Manager
 */
public class Gui implements InventoryHolder {

    /**
     * MAX Inventory SIZE
     */
    public static final int MAX_SIZE = 54;

    private Inventory inv;
    @Getter
    private int size = 0;
    @Getter
    private String name = "";

    /**
     * Initializes the GUI
     * @param name sets the gui's name
     * @param size sets the gui's size
     */
    public Gui(String name, int size) {
        inv = Bukkit.createInventory(this, size, Color.colorize(name));
        this.name = Color.colorize(name);
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
     * @param i the slot to set
     * @param item the item to set it to
     */
    public void setItem(int i, ItemStack item) {
        inv.setItem(i, item);
    }


    /**
     *
     * @return returns the inventory of the gui
     */
    @Override
    public Inventory getInventory() {
        return inv;
    }

    public boolean equals(InventoryView view, Inventory inventory) {
        if(inventory != view.getTopInventory()) return false;
        if(!getName().equals(Color.colorize(view.getTitle()))) return false;
        return true;
    }
}
