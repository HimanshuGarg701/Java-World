package com.javaworld.leetcode;

public class P0065ValidNumber {
    public boolean isNumber(String s) {
        boolean digitSeen = false, exponentSeen = false, digitAfterExponent = true, dotSeen = false;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                digitSeen = true;
                if (exponentSeen) digitAfterExponent = true;
            } else if (current == '+' || current == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            } else if (current == '.') {
                if (dotSeen || exponentSeen) return false;
                dotSeen = true;
            } else if (current == 'e' || current == 'E') {
                if (exponentSeen || !digitSeen) return false;
                exponentSeen = true;
                digitAfterExponent = false;
            } else return false;
        }
        return digitSeen && digitAfterExponent;
    }
}

