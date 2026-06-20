package com.javaworld.leetcode;

public class P0014LongestCommonPrefix {
    public String longestCommonPrefix(String[] words) {
        if (words.length == 0) return "";
        String prefix = words[0];
        for (int i = 1; i < words.length; i++) {
            while (!words[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}

