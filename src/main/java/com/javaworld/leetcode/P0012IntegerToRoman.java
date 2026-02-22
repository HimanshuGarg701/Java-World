package com.javaworld.leetcode;

public class P0012IntegerToRoman {
    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int number) {
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < VALUES.length; i++) {
            while (number >= VALUES[i]) {
                roman.append(SYMBOLS[i]);
                number -= VALUES[i];
            }
        }
        return roman.toString();
    }
}

