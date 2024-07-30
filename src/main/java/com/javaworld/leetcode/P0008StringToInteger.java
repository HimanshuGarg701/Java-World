package com.javaworld.leetcode;

public class P0008StringToInteger {
    public int myAtoi(String s) {
        int index = 0, sign = 1;
        long value = 0;
        while (index < s.length() && s.charAt(index) == ' ') index++;
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = s.charAt(index++) == '-' ? -1 : 1;
        }
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            value = value * 10 + s.charAt(index++) - '0';
            long signed = sign * value;
            if (signed > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (signed < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int) (sign * value);
    }
}

