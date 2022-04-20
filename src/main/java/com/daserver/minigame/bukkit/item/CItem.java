package com.daserver.minigame.bukkit.item;

import com.daserver.minigame.bukkit.item.components.AbilityType;
import com.daserver.minigame.bukkit.item.components.ItemType;
import org.bukkit.Material;

/**
 * An abstract item class used for building items
 */
public abstract class CItem {

    /**
     * gets the Material
     * @return returns the Material of the item
     */
    public abstract Material getMaterial();

    /**
     * gets the items name
     * @return returns the name of the item
     */
    public abstract String getName();

    /**
     * gets the description of the item
     * @return returns the items description
     */
    public abstract String[] getDescription();

    /**
     * gets if the item is glowing
     * @return returns the item glowing
     */
    public abstract boolean isGlowing();

    /**
     * gets the items abilities name
     * @return returns the items ability name
     */
    public abstract String getAbilityName();

    /**
     * gets the items ability description
     * @return returns the items ability description
     */
    public abstract String[] getAbilityDescription();

    /**
     * gets the items ability type
     * @return returns the items ability type
     */
    public abstract AbilityType getAbilityType();

    /**
     * gets the ItemType
     * @return returns the ItemType
     */
    public abstract ItemType getItemType();
}
