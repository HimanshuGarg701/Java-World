package com.javaworld.leetcode;

public class P0028FindFirstOccurrence {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int[] prefix = new int[needle.length()];
        for (int i = 1, matched = 0; i < needle.length(); i++) {
            while (matched > 0 && needle.charAt(i) != needle.charAt(matched)) matched = prefix[matched - 1];
            if (needle.charAt(i) == needle.charAt(matched)) matched++;
            prefix[i] = matched;
        }
        for (int i = 0, matched = 0; i < haystack.length(); i++) {
            while (matched > 0 && haystack.charAt(i) != needle.charAt(matched)) matched = prefix[matched - 1];
            if (haystack.charAt(i) == needle.charAt(matched)) matched++;
            if (matched == needle.length()) return i - needle.length() + 1;
        }
        return -1;
    }
}

