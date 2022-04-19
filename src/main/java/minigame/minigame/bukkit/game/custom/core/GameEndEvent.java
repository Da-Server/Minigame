package minigame.minigame.bukkit.game.custom.core;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


/**
 * A game custom event called when the game ends
 */
public class GameEndEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();

    private final boolean isForced;
    private final long timeStamp;

    public GameEndEvent(boolean isForced) {
        this.isForced = isForced;
        this.timeStamp = System.currentTimeMillis();
    }


    public boolean isForced() {
        return isForced;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }
}
