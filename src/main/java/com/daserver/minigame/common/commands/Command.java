package com.daserver.minigame.common.commands;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Commands class that will allow the CommandManager to handle command requests.
 * @see CommandManager
 */
public abstract class Command {

    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String permission;
    @Setter
    @Getter
    private String[] aliases;
    @Setter
    @Getter
    private String description;

    /**
     * Prepare the command for execution.
     */
    public abstract void init();

    /**
     * The logic for the commands functionality
     * @param player
     * @param args
     */
    public abstract void execute(Player player, ArrayList <String> args);
}
