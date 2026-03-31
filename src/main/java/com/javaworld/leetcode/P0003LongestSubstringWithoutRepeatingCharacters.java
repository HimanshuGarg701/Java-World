package com.javaworld.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P0003LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> last = new HashMap<>();
        int start = 0, best = 0;
        for (int end = 0; end < s.length(); end++) {
            char current = s.charAt(end);
            if (last.containsKey(current)) start = Math.max(start, last.get(current) + 1);
            last.put(current, end);
            best = Math.max(best, end - start + 1);
        }
        return best;
    }
}

