package com.daserver.minigame.common.util;

import com.daserver.minigame.Minigame;

/**
 * Easier logging
 */
public class Log {

    public static void log(String msg) {
        Minigame.getInstance().getLogger().info(msg);
    }
}
