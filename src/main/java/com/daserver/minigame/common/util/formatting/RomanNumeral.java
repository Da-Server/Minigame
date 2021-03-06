package com.daserver.minigame.common.util.formatting;

import java.util.TreeMap;

/**
 * A Class used to convert integers into a roman numeral string
 */
public class RomanNumeral {

    private final static TreeMap <Integer, String> map = new TreeMap<Integer, String>();

    static {

        map.put(100000, "ↈ");
        map.put(50000, "ↇ");
        map.put(10000, "ↂ");
        map.put(5000, "ↁ");
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    public static String toRoman(int number) {
        try {
            int l = map.floorKey(number);
            if (number == l) {
                return map.get(number);
            }
            return map.get(l) + toRoman(number - l);
        } catch(Exception e) {
            return null;
        }
    }
}
