package minigame.minigame.bukkit.position;

import minigame.minigame.Minigame;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Manage spawn positions.
 */
public class PositionManager {
    public static final HashMap<Location, UUID> posMap = new HashMap<>();
    public static final ArrayList<Location> locations = new ArrayList<>();

    public static final Location PRE_GAME = new Location(Minigame.world, 0, 200, 0);

    /**
     * Initialise the position manager
     */
    public static void init() {
        locations.add(getLoc(0,100,0));
        locations.add(getLoc(1,100,0));
        locations.add(getLoc(0,100,1));
    }

    /**
     * Pick a location for each player
     * @param player The player that needs a location
     * @return the location that the player has been given to spawn in
     * @see Location
     */
    public static Location pickLoc(Player player) {
        UUID id = player.getUniqueId();
        int i = 0;
        for(Location l : locations) {
            if(!posMap.containsKey(l)) {
                posMap.put(l, id);
            }
            i++;
        }

        Location finalLoc = locations.get(i);
        locations.remove(i);
        return finalLoc;

    }

    /**
     * Get a location within the world
     * @param x The X coordinate.
     * @param y The Y coordinate.
     * @param z The Z coordinate.
     * @return The location specified.
     * @see Location
     */
    private static Location getLoc(int x, int y, int z) {
        return new Location(Minigame.world, x,y,z);
    }
}
