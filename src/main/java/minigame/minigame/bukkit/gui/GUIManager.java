package minigame.minigame.bukkit.gui;

import lombok.Getter;
import minigame.minigame.common.util.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GUIManager implements Listener {
    @Getter
    private ArrayList<Gui> guis = new ArrayList<>();
    private Map <String, Gui> idMap = new HashMap <>();

    public void registerGui(String id, Gui gui) {
        guis.add(gui);
        idMap.put(id, gui);
    }

}
