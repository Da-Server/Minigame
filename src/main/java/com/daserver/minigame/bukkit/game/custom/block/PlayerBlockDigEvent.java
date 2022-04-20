package com.daserver.minigame.bukkit.game.custom.block;

import lombok.Getter;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * A Custom event handled by BlockHandler class
 * Gets Called While a player is digging
 */
public class PlayerBlockDigEvent extends Event implements Cancellable {

    //getting the player
    @Getter
    private final Player player;

    //getting the block
    @Getter
    private final Block block;

    //getting the action, handler and cancelled
    @Getter
    private final BlockAction action;
    public static HandlerList HANDLER = new HandlerList();
    private boolean cancelled = false;


    /**
     *
     * Allows you to check if a player is mining a block.
     *
     * @param player the person that is mining the block.
     * @param block what block is getting broken.
     * @param action what action is going on while the block is being broken.
     */
    public PlayerBlockDigEvent(Player player, Block block, BlockAction action) {

        //player
        this.player = player;

        //block
        this.block = block;

        //action
        this.action = action;

    }


    //iscancelled
    @Override
    public boolean isCancelled() {
        return cancelled;
    }


    //set cancelled
    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }


    //gethandlers
    @Override
    public HandlerList getHandlers() {
        return HANDLER;
    }


    //get handler list
    public static HandlerList getHandlerList(){
        return HANDLER;
    }

}
