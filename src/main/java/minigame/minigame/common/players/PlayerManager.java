package minigame.minigame.common.players;

import minigame.minigame.common.points.PlayerStats;
import org.bukkit.entity.Player;

import java.util.*;

/**
 * A Manager for player statistics and Players
 */
public class PlayerManager {

    private final List <Player> players = new ArrayList<>();
    private final Map<UUID, PlayerStats> stats = new HashMap <>();


    /**
     * adds a player to the playerList
     * @param player the player to add to the list
     */
    public void add(Player player) {
        players.add(player);
        stats.put(player.getUniqueId(), new PlayerStats(player));
    }

    /**
     * removes a player from the list
     * @param player the player to remove from the list
     */
    public void remove(Player player) {
        players.remove(player);
        stats.remove(player.getUniqueId());
    }

    /**
     * get the playerList
     * @return returns the playerList
     */
    public List<Player> getPlayerList() {
        return players;
    }

    /**
     *
     * @param player the player for the stats
     * @return returns the players points
     */
    public int getPlayerPoints(Player player) {
        PlayerStats playerStats = stats.get(player.getUniqueId());
        return playerStats.getPoints();
    }

    /**
     *
     * @param player the player for the stats
     * @return returns the players kills
     */
    public int getPlayerKills(Player player) {
        PlayerStats playerStats = stats.get(player.getUniqueId());
        return playerStats.getKills();
    }

    /**
     *
     * @param player the player for the stats
     * @return returns the players stats
     */
    public PlayerStats getPlayerStats(Player player) {
        return stats.get(player.getUniqueId());
    }


}
