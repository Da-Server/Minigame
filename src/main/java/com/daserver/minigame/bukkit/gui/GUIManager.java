package com.daserver.minigame.bukkit.gui;

import lombok.Getter;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GUIManager implements Listener {
    @Getter
    private ArrayList<Gui> guis = new ArrayList<>();
    private Map <String, Gui> idMap = new HashMap <>();

    public void registerGui(String id, Gui gui) {
        guis.add(gui);
        idMap.put(id, gui);
    }

}
