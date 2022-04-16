package minigame.minigame.bukkit.item.components;

import lombok.Getter;
import org.bukkit.ChatColor;

public enum ItemType {
    TOOL(ChatColor.GOLD),
    WEAPON(ChatColor.RED),
    MAGICAL(ChatColor.LIGHT_PURPLE),

    ;
    @Getter
    private ChatColor color;
    ItemType(ChatColor color) {
        this.color = color;
    }
}
