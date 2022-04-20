package minigame.minigame.common.util;

public enum Symbol {

    //Some of these symbols will be added in a texture pack!
    //All of these symbols have a purpose, whether they aren't used yet\\\
    STAR("★"),
    HEART("❤"),
    SHEILD("\uD83D\uDEE1"),
    LIGHTNING("⚡"),
    SKELETON("☠"),
    BALLOT("✘"),
    CHECK("✔"),
    WARNING("⚠"),
    DOUBLE_SWORD("⚔"),
    DOUBLE_ARROW_RIGHT("»"),
    DOUBLE_ARROW_LEFT("«"),
    COIN("⑩"),
    FLAME("\uD83D\uDD25"),
    WAVE("\uD83C\uDF0A"),
    PICKAXE("⛏"),
    HAMMER_AND_PICK("⚒"),
    ANCHOR("⚓"),
    SCALING("⚖"),
    //Used for when we add storms
    UMBRELLA("☔"),
    SOLID_TRIANGLE("▲"),
    TRIANGLE("△"),
    DOWN_TRIANGLE("▼"),
    DOWN_TRIANGLE_HOLO("▽"),
    RECYCLING("♻"),
    YOUTUBE("\uE005"),
    MAGIC("۞"),
    HOLO_STAR("☆"),
    STAR_TWO("✮"),
    STAR_THREE("✯"),
    COMMUNIST("☭"),
    SCISSOR("✄"),
    COPYRIGHT("©"),
    REGISTERED("®"),
    TRADEMARK("™"),
    SOME_WIERD_ASS_CHINESE_SYMBOL("㊣"),
    SOME_WIERD_ASS_CHINESE_SYMBOL2("あ"),
    SOME_WIERD_ASS_CHINESE_SYMBOL3("㊚"),
    SOME_WIERD_ASS_CHINESE_SYMBOL4("㊛"),
    ARROW("➹"),
    INVERTED_STAR("✪"),
    INFINITY("∞"),
    BIG_ASS_CIRCLE("◯"),
    SOME_ROBLOX_SYMBOL("回"),
    INVERTED_FACE("☻"),
    SOME_GERMAN_CURRENCY("⋳"),
    SUN("☼"),

    SOMEGAYSYMBOL("")
    ;

    String symbol;
    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
