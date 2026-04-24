package com.javaworld.leetcode;

public class P0010RegularExpressionMatching {
    public boolean isMatch(String s, String pattern) {
        boolean[][] dp = new boolean[s.length() + 1][pattern.length() + 1];
        dp[0][0] = true;
        for (int j = 2; j <= pattern.length(); j++) {
            if (pattern.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 2];
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= pattern.length(); j++) {
                char p = pattern.charAt(j - 1);
                if (p == '.' || p == s.charAt(i - 1)) dp[i][j] = dp[i - 1][j - 1];
                else if (p == '*') {
                    dp[i][j] = dp[i][j - 2];
                    char repeated = pattern.charAt(j - 2);
                    if (repeated == '.' || repeated == s.charAt(i - 1)) dp[i][j] |= dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][pattern.length()];
    }
}

