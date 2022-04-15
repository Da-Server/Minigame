package minigame.minigame.bukkit.item;

import minigame.minigame.bukkit.item.components.AbilityType;
import org.bukkit.Material;

public abstract class CItem {

    public abstract Material getMaterial();
    public abstract String getName();
    public abstract String[] getDescription();
    public abstract boolean isGlowing();
    public abstract String getAbilityName();
    public abstract String[] getAbilityDescription();
    public abstract AbilityType getAbilityType();
}
