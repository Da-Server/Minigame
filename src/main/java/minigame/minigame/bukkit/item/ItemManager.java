package minigame.minigame.bukkit.item;

import minigame.minigame.common.util.Color;
import minigame.minigame.common.util.SpigotUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * A Manager/Builder for custom items
 */
public class ItemManager {

    private static final HashMap<CItem, ItemStack> itemMap = new HashMap<>();
    private static final HashMap<String, CItem> idMap = new HashMap<>();


    public static ItemStack buildItem(CItem item) {
        ItemStack i = new ItemStack(item.getMaterial());
        ItemMeta meta = i.getItemMeta();

        ArrayList<String> lore = new ArrayList<>();

        if(item.getName() != null) meta.setDisplayName(Color.colorize(item.getName()));

        if(item.getDescription().length > 0) {
            lore.add("");

            for(String s : item.getDescription()) {
                lore.add(Color.colorize(s));
            }

            lore.add("");
        }

        if(item.getAbilityName().length() > 0) {
            lore.add("&c" + item.getAbilityName() + " &e" + item.getAbilityType().name().replace("_", " "));
            if(item.getAbilityDescription().length > 0) {
                lore.addAll(Arrays.asList(item.getAbilityDescription()));

            }
            lore.add("");
        }


        lore = Color.colorizeArrayList(lore);


        if(item.isGlowing())
            meta.addEnchant(Enchantment.DURABILITY, 1000, true);

        meta.spigot().setUnbreakable(true);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS);
        meta.setLore(lore);
        i.setItemMeta(meta);

        itemMap.put(item, i);
        idMap.put(ChatColor.stripColor(item.getName()).replace(" ", "_"), item);



        return i;
    }

}
