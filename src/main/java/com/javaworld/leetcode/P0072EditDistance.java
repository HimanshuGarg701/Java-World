package com.javaworld.leetcode;

public class P0072EditDistance {
    public int minDistance(String first, String second) {
        int[] previous = new int[second.length() + 1];
        for (int j = 0; j <= second.length(); j++) previous[j] = j;
        for (int i = 1; i <= first.length(); i++) {
            int[] current = new int[second.length() + 1];
            current[0] = i;
            for (int j = 1; j <= second.length(); j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) current[j] = previous[j - 1];
                else current[j] = 1 + Math.min(previous[j - 1], Math.min(previous[j], current[j - 1]));
            }
            previous = current;
        }
        return previous[second.length()];
    }
}

