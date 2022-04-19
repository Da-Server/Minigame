package com.daserver.minigame.common.commands;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This class manages commands, and executes their logic.
 * @see Listener
 */
public class CommandManager implements Listener {
    private static final Map<String, Class<? extends Command>> cmdMap = new HashMap<>();

    /**
     * Initiate the command manager.
     */
    public static void init() {
        for (Class<? extends Command> c : cmdMap.values()) {
            try {
                Command command = c.newInstance();

                if (command.getAliases().length > 0) {
                    for (String s : command.getAliases()) {
                        cmdMap.put(s, c);
                    }
                }

            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Register commands to be handled.
     * @param name name of the command.
     * @param command the command class.
     */
    public static void registerCommand(String name, Class<? extends Command> command) {
        cmdMap.put(name, command);
    }


    /**
     * Find and execute the command's logic, when a command is run.
     * @param event The bukkit event
     */
    @EventHandler
    void onCommand(PlayerCommandPreprocessEvent event) throws InstantiationException, IllegalAccessException {
        Player player = event.getPlayer();
        String fullCommand = event.getMessage();
        ArrayList<String> args = new ArrayList<>(Arrays.asList(fullCommand.split(" ")));
        String command = args.get(0);
        args.remove(0);

        Command c = null;
        if (cmdMap.containsKey(command))
            c = cmdMap.get(command).newInstance();

        c.init();

        if (player.hasPermission(c.getPermission()))
            c.execute(player, args);

    }
}
