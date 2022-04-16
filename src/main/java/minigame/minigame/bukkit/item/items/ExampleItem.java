package minigame.minigame.bukkit.item.items;

import minigame.minigame.bukkit.item.CItem;
import minigame.minigame.bukkit.item.components.AbilityType;
import minigame.minigame.bukkit.item.components.ItemType;
import org.bukkit.Material;

public class ExampleItem extends CItem {
    @Override
    public Material getMaterial() {
        return Material.DIAMOND;
    }

    @Override
    public String getName() {
        return "Please kill me";
    }

    @Override
    public String[] getDescription() {
        return new String[] {
                "&7I can't do this help"
        };
    }

    @Override
    public boolean isGlowing() {
        return true;
    }

    @Override
    public String getAbilityName() {
        return "Please die";
    }

    @Override
    public String[] getAbilityDescription() {
        return new String[] {
                "&7Please aaa"
        };
    }

    @Override
    public AbilityType getAbilityType() {
        return AbilityType.RIGHT_CLICK;
    }

    @Override
    public ItemType getItemType() {
        return ItemType.MAGICAL;
    }
}
