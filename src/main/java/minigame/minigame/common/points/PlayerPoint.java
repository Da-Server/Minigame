package minigame.minigame.common.custom;

import lombok.Getter;
import lombok.Setter;
import minigame.minigame.common.annotation.PlayerPoints;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Point {

    @Getter
    private int value = 0;

    @Getter
    private UUID player = null;

    public Point(int value, Player player) {
        this.value = value;
        this.player = player.getUniqueId();
    }

    public void add(int amount) {
        value += amount;
    }
    public void subtract(int amount) {
        value -= amount;
    }
    public void setAmount(int amount) {
        value = amount;
    }
    public void multiply(int amount) {
        value *= amount;
    }
    public void divide(int amount) {
        value /= amount;
    }
    public void power(int amount) {
        value = (int)Math.min(Math.pow(value, amount), Integer.MAX_VALUE);
    }
    public void reset() {
        value = 0;
    }





}
