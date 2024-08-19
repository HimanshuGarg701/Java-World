package com.javaworld.leetcode;

public class P0076MinimumWindowSubstring {
    public String minWindow(String s, String target) {
        if (target.isEmpty() || target.length() > s.length()) return "";
        int[] needed = new int[128];
        for (char c : target.toCharArray()) needed[c]++;
        int missing = target.length(), left = 0, bestStart = 0, bestLength = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            if (needed[s.charAt(right)]-- > 0) missing--;
            while (missing == 0) {
                if (right - left + 1 < bestLength) {
                    bestStart = left;
                    bestLength = right - left + 1;
                }
                if (++needed[s.charAt(left++)] > 0) missing++;
            }
        }
        return bestLength == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLength);
    }
}

