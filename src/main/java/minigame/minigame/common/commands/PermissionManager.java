package minigame.minigame.common.commands;

/**
 * A Variable holder for permission strings
 */
public class PermissionManager {
    public static String FORCE_START = createPermission("forcestart");
    public static String FORCE_END= createPermission("forceend");
    public static String CUSTOM_ITEM  = createPermission("customitem");

    /**
     * creates a permission string
     * @param permission the string that will be added
     * @return returns the joined string
     */
    private static String createPermission(String permission) {
        return "minigame." +permission;
    }
}
