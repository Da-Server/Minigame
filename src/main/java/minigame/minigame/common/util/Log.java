package minigame.minigame.common.util;

import lombok.extern.slf4j.Slf4j;
import minigame.minigame.Minigame;

/**
 * Easier logging
 */
public class Log {

    public static void log(String msg) {
        Minigame.getInstance().getLogger().info(msg);
    }
}
