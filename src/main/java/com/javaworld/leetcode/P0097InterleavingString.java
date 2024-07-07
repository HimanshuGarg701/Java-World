package com.javaworld.leetcode;

public class P0097InterleavingString {
    public boolean isInterleave(String first, String second, String target) {
        if (first.length() + second.length() != target.length()) return false;
        boolean[] possible = new boolean[second.length() + 1];
        possible[0] = true;
        for (int j = 1; j <= second.length(); j++) {
            possible[j] = possible[j - 1] && second.charAt(j - 1) == target.charAt(j - 1);
        }
        for (int i = 1; i <= first.length(); i++) {
            possible[0] &= first.charAt(i - 1) == target.charAt(i - 1);
            for (int j = 1; j <= second.length(); j++) {
                char needed = target.charAt(i + j - 1);
                possible[j] = (possible[j] && first.charAt(i - 1) == needed) ||
                        (possible[j - 1] && second.charAt(j - 1) == needed);
            }
        }
        return possible[second.length()];
    }
}

