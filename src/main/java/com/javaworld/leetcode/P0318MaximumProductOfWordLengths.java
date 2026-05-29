package com.javaworld.leetcode;

public class P0318MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) masks[i] |= 1 << (c - 'a');
        }
        int best = 0;
        for (int first = 0; first < words.length; first++) {
            for (int second = first + 1; second < words.length; second++) {
                if ((masks[first] & masks[second]) == 0) {
                    best = Math.max(best, words[first].length() * words[second].length());
                }
            }
        }
        return best;
    }
}
