package minigame.minigame.bukkit.game.custom.packet;

import io.netty.channel.*;
import minigame.minigame.bukkit.game.custom.block.BlockAction;
import minigame.minigame.bukkit.game.custom.block.PlayerBlockDigEvent;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayInBlockDig;
import net.minecraft.server.v1_8_R3.PacketPlayInUpdateSign;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

/**
 * A Packet Event handler handling packet events
 */
public class PacketSignUpdateHandler {
    /**
     * Removed the player from the handler
     * @param player the player to be removed
     */
    public void remove(Player player) {

        Channel channel = ((CraftPlayer)player).getHandle().playerConnection.networkManager.channel;

        channel.eventLoop().submit(() -> {

            channel.pipeline().remove(player.getName());

            //returning null
            return null;
        });
    }

    /**
     * Handles the packets
     * @param player the player that edited it
     * @param plugin the plugin detecting the update
     */
    public void handle(Player player, JavaPlugin plugin){


        ChannelDuplexHandler handler = new ChannelDuplexHandler(){

            @Override
            public void channelRead(ChannelHandlerContext channelHandlerContext, Object p) throws Exception {
                if(p instanceof PacketPlayInUpdateSign){

                    PacketPlayInUpdateSign packet = (PacketPlayInUpdateSign) p;

                    BlockPosition a = (BlockPosition) value(packet,"a");

                    IChatBaseComponent[] text = packet.b();

                    //get the block
                    Block d = player.getLocation().getWorld().getBlockAt(a.getX(),a.getY(),a.getZ());


                    String[] strings = new String[text.length];
                    int j = 0;
                    for(IChatBaseComponent c : text) {
                        strings[j] = c.getText();
                        j++;
                    }

                    PacketSignUpdateEvent update = new PacketSignUpdateEvent(player, strings, d, packet);

                    if(update.isCancelled()){
                        return;
                    }
                    Bukkit.getScheduler().runTaskLater(plugin, () -> Bukkit.getPluginManager().callEvent(update),0);
                }
                //channel read
                super.channelRead(channelHandlerContext, p);

            }

            //write
            @Override
            public void write(ChannelHandlerContext channelHandlerContext, Object packet, ChannelPromise channelPromise) throws Exception {

                super.write(channelHandlerContext, packet, channelPromise);
            }
        };
        //getting the pipeline
        ChannelPipeline pipeline = ((CraftPlayer)player).getHandle().playerConnection.networkManager.channel.pipeline();

        //add to the pipeline
        pipeline.addBefore("packet_handler", player.getName(),handler);
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
