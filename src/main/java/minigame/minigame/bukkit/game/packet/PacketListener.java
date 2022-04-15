package minigame.minigame.bukkit.game.packet;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import minigame.minigame.Minigame;

/**
 * A Packet Listener Class that listens for packets and calls Custom Events
 * For the packets to make it easier to use the packets
 */
public class PacketListener {
    private final ProtocolManager manager = Minigame.getInstance().getProtocolManager();

    /**
     * Calls The initialization methods
     */
    public void init() {
        receive();
    }

    /**
     * onPacketReceive tasks are called here
     */
    private void receive() {
        //TODO: ADD EVENTS
    }


    /**
     * gets the used protocolManager
     * @return returns the used ProtocolManager
     */
    public ProtocolManager getManager() {
        return manager;
    }
}
