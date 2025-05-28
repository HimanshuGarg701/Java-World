package com.javaworld.leetcode;

public class P0343IntegerBreak {
    public int integerBreak(int n) {
        int[] best = new int[n + 1];
        best[1] = 1;
        for (int value = 2; value <= n; value++) {
            for (int first = 1; first < value; first++) {
                best[value] = Math.max(best[value], Math.max(first, best[first])
                        * Math.max(value - first, best[value - first]));
            }
        }
        return best[n];
    }
}
