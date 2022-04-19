package minigame.minigame.common.util.org.bukkit;

import lombok.Getter;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BukkitUtil {

    @Getter
    private static final Set <Material> transparent = new HashSet <>();

    static {
        for(Material material : Material.values()) {
            if(material.isBlock())  {
                if(!material.isSolid()) {
                    transparent.add(material);
                }
            }
        }
    }


    /**
     * Calculates a location within a distance in front of a player
     * @param player the player to use the vector calculation
     * @param distance the distance to check
     * @return the calculated location
     */
    public static Location calculateEmpty(Player player, int distance) {
        try {
            int f_ = distance;
            for(int range = 1; range < distance; range++) {
                Location location = player.getTargetBlock(transparent, range).getLocation();
                if (location.getBlock().getType() != Material.AIR) {
                    f_ = range;
                    break;
                }
            }
            Location location = player.getTargetBlock(transparent, f_ - 1).getLocation();
            location.setYaw(player.getLocation().getYaw());
            location.setPitch(player.getLocation().getPitch());
            location.add(0.5, 0, 0.5);
            if (f_ != distance) {
                return null;
            }
            if (f_ > 1) {
                return location;
            }
            else player.teleport(player.getLocation());
        } catch (IllegalStateException ignored) {} // suppress bullshit errors thrown by Player#getTargetBlock
        return null;
    }






}
