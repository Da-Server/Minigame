package minigame.minigame.bukkit.game.events.block;

import minigame.minigame.bukkit.game.custom.block.BlockAction;
import minigame.minigame.bukkit.game.custom.block.PlayerBlockDigEvent;
import minigame.minigame.bukkit.game.custom.packet.PacketSignUpdateEvent;
import net.minecraft.server.v1_8_R3.PacketPlayInUpdateSign;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


public class PlayerBlockUpdateListener implements Listener {

    @EventHandler
    void onBlockDig(PlayerBlockDigEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        BlockAction action = event.getAction();
        
    }

    @EventHandler
    void onSignUpdate(PacketSignUpdateEvent event) {
        Player player = event.getPlayer();
        String[] strings = event.getStrings();
        PacketPlayInUpdateSign packet = event.getPacket();
        Block sign = event.getBlock();

    }
}
