package com.daserver.minigame.bukkit.commands;

import com.daserver.minigame.common.commands.Command;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class TestCommand extends Command {

    @Override
    public void init() {
        setName("test");
    }

    @Override
    public void execute(Player player, ArrayList <String> args) {
        player.sendMessage("this works!");
    }
}
