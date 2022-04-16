package minigame.minigame.common.util;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;
import java.util.Random;

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


    /**
     * gets a random location around a center point
     * @param origin the center point
     * @param radius the radius to fin
     * @param centerRadius the centers radius to ignore
     * @param _3D whether its 3 Dimensional or not
     * @return The location
     */
    public static Location getRandomLocation(Player origin, double radius, double centerRadius, boolean _3D)
    {
        Random r = new Random();
        double randomRadius = r.nextDouble() * radius;
        double theta =  Math.toRadians(r.nextDouble() * 360 - centerRadius);
        double phi = Math.toRadians(r.nextDouble() * 180 - 90 - centerRadius);

        double x = randomRadius * Math.cos(theta) * Math.sin(phi);
        double y = randomRadius * Math.sin(theta) * Math.cos(phi);
        double z = randomRadius * Math.cos(phi);
        Location newLoc = origin.getLocation().add(x, 0, z);
        if (_3D) {
            newLoc.add(0, y, 0);
        }
        return newLoc;
    }



}
