package com.javaworld.leetcode;

public class P0044WildcardMatching {
    public boolean isMatch(String s, String pattern) {
        int text = 0, token = 0, star = -1, retryFrom = 0;
        while (text < s.length()) {
            if (token < pattern.length() &&
                    (pattern.charAt(token) == '?' || pattern.charAt(token) == s.charAt(text))) {
                text++;
                token++;
            } else if (token < pattern.length() && pattern.charAt(token) == '*') {
                star = token++;
                retryFrom = text;
            } else if (star != -1) {
                token = star + 1;
                text = ++retryFrom;
            } else return false;
        }
        while (token < pattern.length() && pattern.charAt(token) == '*') token++;
        return token == pattern.length();
    }
}

