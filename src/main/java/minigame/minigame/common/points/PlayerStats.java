package minigame.minigame.common.points;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * A Holder for a players statistics
 */
public class PlayerStats {

    @Getter
    private int points = 0;

    @Getter
    private int kills = 0;

    @Getter
    private UUID player = null;

    public PlayerStats(Player player) {
        this.player = player.getUniqueId();
    }

    /**
     *
     * @param amount the amount of points to add
     */
    public void addPoints(int amount) {
        points += amount;
    }

    /**
     *
     * @param amount the amount of points to remove
     */
    public void subtractPoints(int amount) {
        points -= amount;
    }
    /**
     *
     * @param amount the number to set the points to
     */
    public void setAmountPoints(int amount) {
        points = amount;
    }
    /**
     *
     * @param amount the amount of points to multiply
     */
    public void multiplyPoints(int amount) {
        points *= amount;
    }
    /**
     *
     * @param amount the amount of points to devide
     */
    public void dividePoints(int amount) {
        points /= amount;
    }
    /**
     *
     * @param amount the amount of points to power
     */
    public void powerPoints(int amount) { points = (int)Math.min(Math.pow(points, amount), Integer.MAX_VALUE); }

    /**
     * reset the points
     */
    public void resetPoints() { points = 0; }


    /**
     * increment the kills
     */
    public void incrementKills() { kills += 1; }

    /**
     * decrement the kills
     */
    public void decrementKills() { kills -= 1; }



}
