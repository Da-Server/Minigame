package minigame.minigame;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import lombok.Getter;
import lombok.SneakyThrows;
import minigame.minigame.bukkit.gui.GUIManager;
import minigame.minigame.bukkit.gui.Gui;
import minigame.minigame.bukkit.item.CItem;
import minigame.minigame.bukkit.item.ItemManager;
import minigame.minigame.bukkit.position.PositionManager;
import minigame.minigame.common.database.MySQL;
import minigame.minigame.common.players.PlayerManager;
import minigame.minigame.common.util.Log;
import minigame.minigame.common.util.XMLReader;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

/**
 * The main plugin class. Used to configure, prepare and execute the plugins functions.
 * @see JavaPlugin
 */
public final class Minigame extends JavaPlugin {

    private static Minigame instance;
    private static final Reflections reflections = new Reflections();
    
    @Getter private XMLReader pomReader;
    @Getter private String version;
    @Getter private String branch;
    @Getter private String MC_VERSION;
    @Getter private String n;
    @Getter private MySQL mysql;

    @Getter private PositionManager positionManager;
    @Getter private PlayerManager playerManager;
    @Getter private ProtocolManager protocolManager;
    @Getter private GUIManager guiManager;


    @Getter private World world;



    @SneakyThrows
    @Override
    public void onEnable() {
        loadProperties();
        initManagers();
        register();

    }

    @Override
    public void onDisable() {
    }

    /**
     * Initialise the managers that the plugin needs to function.
     */
    private void initManagers() throws InstantiationException, IllegalAccessException {
        playerManager = new PlayerManager();
        positionManager = new PositionManager();
        guiManager = new GUIManager();
        positionManager.init();
    }

    @SneakyThrows
    @Override
    public void onLoad() {
        instance = this;
        protocolManager = ProtocolLibrary.getProtocolManager();
    }

    /**
     * Loads the properties from the xml
     */
    private void loadProperties() {
        //mysql = new MySQL();
        //mysql.initialize();
        pomReader = new XMLReader("pom");
        version = pomReader.readString("version");
        branch = pomReader.readString("branch");
        MC_VERSION = pomReader.readString("mc.version");
        n = pomReader.readString("name");

        world = Bukkit.getServer().getWorld("world");

        Log.log("Plugin Successfully enabled! version: " + n + "-" + version + "-" + MC_VERSION);
    }

    /**
     * Registers bukkit events and commands.
     * @throws InstantiationException Reflection was unable to instantiate the class.
     * @throws IllegalAccessException Reelections were unable to access the object.
     *
     * @see Listener
     */
    private void register() throws InstantiationException, IllegalAccessException {
        for(Class<?extends Listener> c : reflections.getSubTypesOf(Listener.class)) {
            Bukkit.getPluginManager().registerEvents(c.newInstance(), this);
        }

        for(Class<? extends CommandExecutor> c : new Reflections("minigame.minigame.bukkit.commands").getSubTypesOf(CommandExecutor.class)) {
            Bukkit.getPluginCommand(c.getSimpleName().toLowerCase()).setExecutor(c.newInstance());
        }

        for(Class<? extends CItem> c : reflections.getSubTypesOf(CItem.class)) {
            ItemManager.buildItem(c.newInstance());
        }

        for(Class<? extends Gui> c : reflections.getSubTypesOf(Gui.class)) {
            guiManager.registerGui(c.getSimpleName().toLowerCase(), c.newInstance());
        }
    }

    /**
     *
     * @return returns the instance in the Minigame Class
     */
    public static Minigame getInstance() {
        return instance;
    }

    /**
     *
     * @return returns the instance of reflections
     */
    public static Reflections getReflections() {
        return reflections;
    }

}
