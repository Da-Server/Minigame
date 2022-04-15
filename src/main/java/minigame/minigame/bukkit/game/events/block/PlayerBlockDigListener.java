package minigame.minigame.bukkit.game.events.block;

import minigame.minigame.bukkit.game.custom.block.BlockAction;
import minigame.minigame.bukkit.game.custom.block.PlayerBlockDigEvent;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * A Listener for the Custom Event PlayerBlockDigEvent
 */
public class PlayerBlockDigListener implements Listener {

    /**
     * the PlayerBlockEvent method
     * @param event the event that is being called
     */
    @EventHandler
    void onBlockDig(PlayerBlockDigEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        BlockAction action = event.getAction();

    }
}
