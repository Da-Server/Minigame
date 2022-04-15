package minigame.minigame.bukkit.position;

import minigame.minigame.Minigame;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class PositionManager {
    public static final HashMap<Location, UUID> posMap = new HashMap<>();
    public static final ArrayList<Location> locations = new ArrayList<>();

    public static final Location PRE_GAME = new Location(Minigame.world, 0, 200, 0);

    public static void init() {

        //
        locations.add(getLoc(0,100,0));
        locations.add(getLoc(1,100,0));
        locations.add(getLoc(0,100,1));
    }

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

    private static Location getLoc(int x, int y, int z) {
        return new Location(Minigame.world, x,y,z);
    }
}
