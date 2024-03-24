package com.javaworld.leetcode;

public class P0338CountingBits {
    public int[] countBits(int n) {
        int[] counts = new int[n + 1];
        for (int value = 1; value <= n; value++) counts[value] = counts[value >>> 1] + (value & 1);
        return counts;
    }
}
