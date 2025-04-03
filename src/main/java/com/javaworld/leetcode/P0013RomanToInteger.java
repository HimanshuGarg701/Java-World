package com.javaworld.leetcode;

public class P0013RomanToInteger {
    public int romanToInt(String s) {
        int total = 0, previous = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int current = value(s.charAt(i));
            total += current < previous ? -current : current;
            previous = current;
        }
        return total;
    }

    private int value(char symbol) {
        return switch (symbol) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> throw new IllegalArgumentException("Invalid Roman numeral");
        };
    }
}

