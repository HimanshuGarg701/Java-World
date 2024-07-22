package com.javaworld.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P0340LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) return 0;
        Map<Character, Integer> counts = new HashMap<>();
        int left = 0;
        int best = 0;
        for (int right = 0; right < s.length(); right++) {
            char value = s.charAt(right);
            counts.put(value, counts.getOrDefault(value, 0) + 1);
            while (counts.size() > k) {
                char removed = s.charAt(left++);
                int remaining = counts.get(removed) - 1;
                if (remaining == 0) counts.remove(removed);
                else counts.put(removed, remaining);
            }
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}
