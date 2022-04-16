package minigame.minigame.common.util;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;

public class SpigotUtil {

    /**
     * Send a title to player
     * @param player Player to send the title to
     * @param text The text displayed in the title
     * @param fadeInTime The time the title takes to fade in
     * @param showTime The time the title is displayed
     * @param fadeOutTime The time the title takes to fade out
     * @param color The color of the title
     */
    public static void sendTitle(Player player, String text, int fadeInTime, int showTime, int fadeOutTime, ChatColor color)
    {
        IChatBaseComponent chatTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + text + "\",color:" + color.name().toLowerCase() + "}");

        PacketPlayOutTitle title = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, chatTitle);
        PacketPlayOutTitle length = new PacketPlayOutTitle(fadeInTime, showTime, fadeOutTime);


        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(title);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(length);
    }



}
