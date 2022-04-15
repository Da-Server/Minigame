package minigame.minigame.bukkit.game.events;

import minigame.minigame.bukkit.game.custom.BlockAction;
import minigame.minigame.bukkit.game.custom.PlayerBlockDigEvent;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerBlockDigListener implements Listener {


    @EventHandler
    void onBlockDig(PlayerBlockDigEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        BlockAction action = event.getAction();

    }
}
