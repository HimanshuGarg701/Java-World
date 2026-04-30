package com.javaworld.leetcode;

public class P0070ClimbingStairs {
    public int climbStairs(int n) {
        int previous = 0, current = 1;
        for (int step = 0; step < n; step++) {
            int next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }
}

