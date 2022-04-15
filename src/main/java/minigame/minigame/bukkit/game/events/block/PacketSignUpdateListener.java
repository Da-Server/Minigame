package minigame.minigame.bukkit.game.events.block;

import minigame.minigame.bukkit.game.custom.packet.PacketSignUpdateEvent;
import net.minecraft.server.v1_8_R3.PacketPlayInUpdateSign;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * A Listener for the PacketSignUpdate event
 */
public class PacketSignUpdateListener implements Listener {

    @EventHandler
    public void onSignUpdate(PacketSignUpdateEvent event) {
        Player player = event.getPlayer();
        String[] strings = event.getStrings();
        PacketPlayInUpdateSign packet = event.getPacket();
        Block sign = event.getBlock();
    }
}
