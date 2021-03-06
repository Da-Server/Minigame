package com.daserver.minigame.bukkit.item;

import com.daserver.minigame.common.util.Color;
import org.bukkit.ChatColor;
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


    /**
     * Builds and item from a CItem
     * @param item the CItem used for building
     * @see CItem
     * @return returns and ItemStack
     */
    public static ItemStack buildItem(CItem item) {
        ItemStack i = new ItemStack(item.getMaterial());
        ItemMeta meta = i.getItemMeta();

        ArrayList<String> lore = new ArrayList<>();

        if(item.getName() != null) meta.setDisplayName(item.getItemType().getColor() + Color.colorize( item.getName()));

        if(item.getDescription().length > 0) {
            lore.add("");

            for(String s : item.getDescription()) {
                lore.add(Color.colorize(s));
            }

            lore.add("");
        }

        if(item.getAbilityName() != null) {
            lore.add(item.getItemType().getColor() + item.getAbilityName() + " &e&l" + item.getAbilityType().name().replace("_", " "));
            lore.add("");
            if(item.getAbilityDescription().length > 0) {
                lore.addAll(Arrays.asList(item.getAbilityDescription()));

            }
            lore.add("");
        }

        if (item.getItemType() != null) {
            lore.add(item.getItemType().getColor() + "&l" + item.getItemType().name().replace("_", " "));
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

    /**
     * gets the item map and
     * @return returns the item map
     */
    public static HashMap <CItem, ItemStack> getItemMap() {
        return itemMap;
    }

    /**
     * gets the id map and
     * @return returns the id map
     */
    public static HashMap <String, CItem> getIdMap() {
        return idMap;
    }

}
