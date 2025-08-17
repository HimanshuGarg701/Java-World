package com.javaworld.leetcode;

public class P0005LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        int bestStart = 0, bestLength = 1;
        for (int center = 0; center < s.length(); center++) {
            int[] odd = expand(s, center, center);
            int[] even = expand(s, center, center + 1);
            int[] longer = odd[1] >= even[1] ? odd : even;
            if (longer[1] > bestLength) {
                bestStart = longer[0];
                bestLength = longer[1];
            }
        }
        return s.substring(bestStart, bestStart + bestLength);
    }

    private int[] expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left + 1, right - left - 1};
    }
}

