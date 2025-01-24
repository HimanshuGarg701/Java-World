package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P0336PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> indices = new HashMap<>();
        for (int i = 0; i < words.length; i++) indices.put(words[i], i);
        List<List<Integer>> result = new ArrayList<>();
        Set<Long> seen = new HashSet<>();
        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            for (int split = 0; split <= word.length(); split++) {
                if (isPalindrome(word, 0, split - 1)) {
                    Integer other = indices.get(reverse(word.substring(split)));
                    add(result, seen, other, index);
                }
                if (split < word.length() && isPalindrome(word, split, word.length() - 1)) {
                    Integer other = indices.get(reverse(word.substring(0, split)));
                    add(result, seen, index, other);
                }
            }
        }
        return result;
    }

    private void add(List<List<Integer>> result, Set<Long> seen, Integer first, Integer second) {
        if (first == null || second == null || first.equals(second)) return;
        long key = ((long) first << 32) ^ (second & 0xffffffffL);
        if (seen.add(key)) result.add(List.of(first, second));
    }

    private boolean isPalindrome(String value, int left, int right) {
        while (left < right) if (value.charAt(left++) != value.charAt(right--)) return false;
        return true;
    }

    private String reverse(String value) {
        return new StringBuilder(value).reverse().toString();
    }
}
