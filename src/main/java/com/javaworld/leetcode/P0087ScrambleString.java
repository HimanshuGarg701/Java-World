package com.javaworld.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P0087ScrambleString {
    private final Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String first, String second) {
        if (first.length() != second.length()) return false;
        String key = first + '\0' + second;
        if (memo.containsKey(key)) return memo.get(key);
        if (first.equals(second)) return remember(key, true);
        int[] frequency = new int[26];
        for (int i = 0; i < first.length(); i++) {
            frequency[first.charAt(i) - 'a']++;
            frequency[second.charAt(i) - 'a']--;
        }
        for (int count : frequency) if (count != 0) return remember(key, false);
        for (int split = 1; split < first.length(); split++) {
            boolean unchanged = isScramble(first.substring(0, split), second.substring(0, split)) &&
                    isScramble(first.substring(split), second.substring(split));
            boolean swapped = isScramble(first.substring(0, split), second.substring(second.length() - split)) &&
                    isScramble(first.substring(split), second.substring(0, second.length() - split));
            if (unchanged || swapped) return remember(key, true);
        }
        return remember(key, false);
    }

    private boolean remember(String key, boolean value) {
        memo.put(key, value);
        return value;
    }
}

