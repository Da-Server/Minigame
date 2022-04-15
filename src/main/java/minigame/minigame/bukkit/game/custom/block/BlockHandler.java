package minigame.minigame.bukkit.game.custom.block;

import io.netty.channel.*;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.PacketPlayInBlockDig;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

/**
 * A Handler for block events
 */
public class BlockHandler {
    /**
     * Removed the player from the handler
     * @param player the player to be removed
     */
    public void remove(Player player) {

        //get the channel
        Channel channel = ((CraftPlayer)player).getHandle().playerConnection.networkManager.channel;

        //event loop
        channel.eventLoop().submit(() -> {

            //remove the player from the pipeline
            channel.pipeline().remove(player.getName());

            //returning null
            return null;
        });
    }

    /**
     * Handles the packets
     * @param player the player that's breaking it
     * @param plugin the plugin detecting the breaking
     */
    public void handle(Player player, JavaPlugin plugin){


        //Getting channel handler
        ChannelDuplexHandler handler = new ChannelDuplexHandler(){

            //channel read
            @Override
            public void channelRead(ChannelHandlerContext channelHandlerContext, Object packet) throws Exception {
                //if the packet is PlayInBlockDig
                if(packet instanceof PacketPlayInBlockDig){

                    //create the packet
                    PacketPlayInBlockDig block = (PacketPlayInBlockDig) packet;

                    //get the block pos
                    BlockPosition a = (BlockPosition) value(block,"a");

                    //get the type
                    PacketPlayInBlockDig.EnumPlayerDigType c = ( PacketPlayInBlockDig.EnumPlayerDigType) value(block,"c");

                    //get the block
                    Block d = player.getLocation().getWorld().getBlockAt(a.getX(),a.getY(),a.getZ());

                    //add the action
                    BlockAction action;

                    //switch through the enum
                    switch (c) {
                        case STOP_DESTROY_BLOCK:
                            action = BlockAction.STOP;
                            break;
                        case START_DESTROY_BLOCK:
                            action = BlockAction.START;
                            break;
                        case ABORT_DESTROY_BLOCK:
                            action = BlockAction.ABORT;
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + c);

                    }


                    //the event
                    PlayerBlockDigEvent dig = new PlayerBlockDigEvent(player,d,action);

                    //if its cancelled return
                    if(dig.isCancelled()){

                        //returning
                        return;
                    }
                    //run a task later
                    Bukkit.getScheduler().runTaskLater(plugin, () -> Bukkit.getPluginManager().callEvent(dig),0);
                }
                //channel read
                super.channelRead(channelHandlerContext, packet);

            }

            //write
            @Override
            public void write(ChannelHandlerContext channelHandlerContext, Object packet, ChannelPromise channelPromise) throws Exception {

                super.write(channelHandlerContext, packet,channelPromise);
            }
        };
        //getting the pipeline
        ChannelPipeline pipeline = ((CraftPlayer)player).getHandle().playerConnection.networkManager.channel.pipeline();

        //add to the pipeline
        pipeline.addBefore("packet_handler",player.getName(),handler);
    }
    private  Object value(Object instance, String name){
        //make result null
        Object result = null;

        try{
            //getting the field
            Field field = instance.getClass().getDeclaredField(name);

            //setting the field accessable
            field.setAccessible(true);

            //setting the resault equal to the instance
            result = field.get(instance);

            //setting the field not accessable
            field.setAccessible(false);
        }//catching the error
        catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
