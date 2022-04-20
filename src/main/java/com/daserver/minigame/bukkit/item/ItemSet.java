package com.daserver.minigame.bukkit.item;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemSet {

    public static int MAX_CAPACITY = 54;

    @Getter
    private List <ItemStack> contents = new ArrayList<>();

    /**
     * initializes the item set
     * @param items the items for the inputs
     */
    public ItemSet(ItemStack... items) {
        contents.addAll(Arrays.asList(items));
        if(items.length > MAX_CAPACITY) {
            throw new IllegalArgumentException("Too large");
        }
    }

    /**
     * Set an item to the contents
     * @param slot the slot to set
     * @param i the item to set
     */
    public void setItem(int slot, ItemStack i) {
        contents.set(slot, i);
        if(slot > MAX_CAPACITY) {
            throw new IllegalArgumentException("Above 54");
        }
    }


}
