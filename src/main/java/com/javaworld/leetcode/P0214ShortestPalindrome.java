package com.javaworld.leetcode;

public class P0214ShortestPalindrome {
    public String shortestPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        String combined = s + '#' + reversed;
        int[] prefix = new int[combined.length()];
        for (int index = 1; index < combined.length(); index++) {
            int matched = prefix[index - 1];
            while (matched > 0 && combined.charAt(index) != combined.charAt(matched)) {
                matched = prefix[matched - 1];
            }
            if (combined.charAt(index) == combined.charAt(matched)) matched++;
            prefix[index] = matched;
        }
        int palindromicPrefix = prefix[combined.length() - 1];
        return reversed.substring(0, s.length() - palindromicPrefix) + s;
    }
}
