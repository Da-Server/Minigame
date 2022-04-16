package minigame.minigame.common.util.formatting;

import minigame.minigame.bukkit.game.Game;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A System to replace parts of a string with a certain value
 *
 */
public class Placeholder {
    private static Map <String, String> properties = new HashMap<String, String>();
    private static final Pattern PLACEHOLDER_PATTERN = Pattern.compile("(?<escape>\\\\)?\\$\\{(?<name>[^{}]+)\\}");


    /**
     *
     * @param player the player to use for player based placeholders
     * @param str the input string that will be replaced
     * @return outputs the string with placeholders
     */
    public static String placeholder(Player player, String str) {

        properties.put("PLAYER_COUNT", Game.getPlayerCount() + "");
        properties.put("PLAYER_NAME", player.getName());
        properties.put("GRADIANT_INT", "&6");
        Matcher matcher = PLACEHOLDER_PATTERN.matcher(str);

        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            String replacement = matcher.group("escape") != null ?
                    matcher.group().substring(1) :
                    properties.containsKey(matcher.group("name")) ?
                            placeholder(player, properties.get(matcher.group("name")) + "") :
                            matcher.group();
            matcher.appendReplacement(buffer, Matcher.quoteReplacement(replacement));

        }

        matcher.appendTail(buffer);

        return buffer.toString();

    }
    /**
     * @param i the value used for number based placeholders
     * @param player the player to use for player based placeholders
     * @param str the input string that will be replaced
     * @return outputs the string with placeholders
     */
    public static String placeholder(int i, Player player, String str) {

        properties.put("PLAYER_COUNT", Game.getPlayerCount() + "");
        properties.put("PLAYER_NAME", player.getName());
        properties.put("GRADIANT_INT", "&6");
        properties.put("COUNT_DOWN_NUMBER", i + "");
        properties.put("COUNT_DOWN_NUMBER_ROMAN", RomanNumeral.toRoman(i) + "");


        Matcher matcher = PLACEHOLDER_PATTERN.matcher(str);

        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            String replacement = matcher.group("escape") != null ?
                    matcher.group().substring(1) :
                    properties.containsKey(matcher.group("name")) ?
                            placeholder(i, player, properties.get(matcher.group("name")) + "") :
                            matcher.group();
            matcher.appendReplacement(buffer, Matcher.quoteReplacement(replacement));

        }

        matcher.appendTail(buffer);

        return buffer.toString();

    }

    /**
     * @param player the player to use for player based placeholders
     * @param player2 the player used for multi player placeholders
     * @param str the input string that will be replaced
     * @return outputs the string with placeholders
     */
    public static String placeholder(Player player, Player player2, String str) {

        properties.put("PLAYER_COUNT", Game.getPlayerCount() + "");
        properties.put("PLAYER_NAME", player.getName());
        properties.put("GRADIANT_INT", "&6");
        properties.put("VICTIM", player.getName());
        properties.put("KILLER", player2.getName());


        Matcher matcher = PLACEHOLDER_PATTERN.matcher(str);

        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            String replacement = matcher.group("escape") != null ?
                    matcher.group().substring(1) :
                    properties.containsKey(matcher.group("name")) ?
                            placeholder(player, player2, properties.get(matcher.group("name")) + "") :
                            matcher.group();
            matcher.appendReplacement(buffer, Matcher.quoteReplacement(replacement));

        }

        matcher.appendTail(buffer);

        return buffer.toString();

    }
    /**
     * @param player the player to use for player based placeholders
     * @param item the player used for multi player placeholders
     * @param str the input string that will be replaced
     * @return outputs the string with placeholders
     */
    public static String placeholder(ItemStack item , Player player, String str) {

        properties.put("PLAYER_COUNT", Game.getPlayerCount() + "");
        properties.put("PLAYER_NAME", player.getName());
        properties.put("GRADIANT_INT", "&6");
        properties.put("ITEM", item.getItemMeta().getDisplayName());


        Matcher matcher = PLACEHOLDER_PATTERN.matcher(str);

        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            String replacement = matcher.group("escape") != null ?
                    matcher.group().substring(1) :
                    properties.containsKey(matcher.group("name")) ?
                            placeholder(item, player, properties.get(matcher.group("name")) + "") :
                            matcher.group();
            matcher.appendReplacement(buffer, Matcher.quoteReplacement(replacement));

        }

        matcher.appendTail(buffer);

        return buffer.toString();

    }



}
