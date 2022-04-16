package minigame.minigame.bukkit.game.custom.packet;

import lombok.Getter;
import minigame.minigame.bukkit.game.custom.block.BlockAction;
import net.minecraft.server.v1_8_R3.PacketPlayInUpdateSign;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * A Custom Event For Sign Updates
 */
public class PacketSignUpdateEvent extends Event implements Cancellable {
    @Getter
    private final Player player;

    @Getter
    private final String[] strings;

    private boolean isCancelled = false;

    @Getter
    private PacketPlayInUpdateSign packet;


    @Getter
    private final Block block;

    public static HandlerList HANDLER = new HandlerList();

    public PacketSignUpdateEvent(Player player, String[] strings, Block block, PacketPlayInUpdateSign packet) {
        this.player = player;
        this.strings = strings;
        this.block = block;
        this.packet = packet;
    }

    /**
     *
     * @return is the event cancelled
     */
    @Override
    public boolean isCancelled() {

        return isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        isCancelled = b;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER;
    }

    public static HandlerList getHandlerList(){
        return HANDLER;
    }

    public void write(String... write) {

    }

}
