package minigame.minigame.common.util.formatting;

import minigame.minigame.bukkit.game.Game;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Placeholder {
    private static Map <String, String> properties = new HashMap<String, String>();
    private static final Pattern PLACEHOLDER_PATTERN = Pattern.compile("(?<escape>\\\\)?\\$\\{(?<name>[^{}]+)\\}");

    public static String placeholder(int i, Player player, String str) {

        properties.put("PLAYER_COUNT", Game.getPlayerCount() + "");
        properties.put("PLAYER_NAME", player.getName());
        properties.put("GRADIANT_INT", "&6");
        properties.put("COUNT_DOWN_NUMBER", i + "");


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



}
