package com.javaworld.leetcode;

public class P0091DecodeWays {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') return 0;
        int twoBack = 1, oneBack = 1;
        for (int i = 1; i < s.length(); i++) {
            int current = s.charAt(i) == '0' ? 0 : oneBack;
            int pair = (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0';
            if (pair >= 10 && pair <= 26) current += twoBack;
            twoBack = oneBack;
            oneBack = current;
        }
        return oneBack;
    }
}

