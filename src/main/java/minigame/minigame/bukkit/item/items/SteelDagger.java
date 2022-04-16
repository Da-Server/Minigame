package minigame.minigame.bukkit.item.items;

import minigame.minigame.bukkit.item.CItem;
import minigame.minigame.bukkit.item.components.AbilityType;
import minigame.minigame.bukkit.item.components.ItemType;
import org.bukkit.Material;

public class SteelDagger extends CItem {
    @Override
    public Material getMaterial() {
        return Material.IRON_SWORD;
    }

    @Override
    public String getName() {
        return "Steel Dagger";
    }

    @Override
    public String[] getDescription() {
        return new String[] {
                "&7A Dagger than can be used for",
                "&7many purposes one of which",
                "&7being murder!"
        };
    }

    @Override
    public boolean isGlowing() {
        return false;
    }

    @Override
    public String getAbilityName() {
        return null;
    }

    @Override
    public String[] getAbilityDescription() {
        return new String[0];
    }

    @Override
    public AbilityType getAbilityType() {
        return null;
    }
    @Override
    public ItemType getItemType() {
        return ItemType.WEAPON;
    }
}
