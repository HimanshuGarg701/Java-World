package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P0030SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0) return result;
        int wordLength = words[0].length();
        Map<String, Integer> needed = new HashMap<>();
        for (String word : words) needed.merge(word, 1, Integer::sum);
        for (int offset = 0; offset < wordLength; offset++) {
            Map<String, Integer> window = new HashMap<>();
            int left = offset, count = 0;
            for (int right = offset; right + wordLength <= s.length(); right += wordLength) {
                String word = s.substring(right, right + wordLength);
                if (!needed.containsKey(word)) {
                    window.clear();
                    count = 0;
                    left = right + wordLength;
                    continue;
                }
                window.merge(word, 1, Integer::sum);
                count++;
                while (window.get(word) > needed.get(word)) {
                    String removed = s.substring(left, left + wordLength);
                    window.merge(removed, -1, Integer::sum);
                    left += wordLength;
                    count--;
                }
                if (count == words.length) {
                    result.add(left);
                    String removed = s.substring(left, left + wordLength);
                    window.merge(removed, -1, Integer::sum);
                    left += wordLength;
                    count--;
                }
            }
        }
        return result;
    }
}

