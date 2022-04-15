package minigame.minigame.common.commands;

public class PermissionManager {
    public static String FORCE_START = createPermission("forcestart");
    public static String FORCE_END= createPermission("forceend");



    private static String createPermission(String permission) {
        return "minigame." +permission;
    }
}
