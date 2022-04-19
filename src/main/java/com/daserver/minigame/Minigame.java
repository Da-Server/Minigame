package com.daserver.minigame;

import lombok.SneakyThrows;
import com.daserver.minigame.common.commands.Command;
import com.daserver.minigame.common.commands.CommandManager;
import com.daserver.minigame.bukkit.position.PositionManager;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

/**
 * The main plugin class. Used to configure, prepare and execute the plugins functions.
 * @see JavaPlugin
 */

public final class Minigame extends JavaPlugin {

    //TODO: Singleton & hide fields.
    public static Minigame instance;
    public static Reflections reflections = new Reflections();

    public static World world = Bukkit.getWorld("world");

    @SneakyThrows
    @Override
    public void onEnable() {
        initManagers();
        register();
    }

    @Override
    public void onDisable() {
    }

    /**
     * Initialise the managers that the plugin needs to function.
     */
    private void initManagers() {
        PositionManager.init();
        CommandManager.init();
    }

    @SneakyThrows
    @Override
    public void onLoad() {
        instance = this;
    }

    /**
     * Registers bukkit events and commands.
     * @throws InstantiationException Reflection was unable to instantiate the class.
     * @throws IllegalAccessException Reelections were unable to access the object.
     *
     * @see Listener
     * @see Command
     */
    private void register() throws InstantiationException, IllegalAccessException {
        for(Class<?extends Listener> c : reflections.getSubTypesOf(Listener.class)) {
            Bukkit.getPluginManager().registerEvents(c.newInstance(), this);
        }
        for(Class<?extends Command> c : reflections.getSubTypesOf(Command.class)) {
            CommandManager.registerCommand(c.newInstance().getName(), c);
        }
    }
}
