package com.javaworld.leetcode;

public class P0029DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long remaining = Math.abs((long) dividend);
        long positiveDivisor = Math.abs((long) divisor);
        long quotient = 0;
        for (int bit = 31; bit >= 0; bit--) {
            if ((remaining >> bit) >= positiveDivisor) {
                remaining -= positiveDivisor << bit;
                quotient += 1L << bit;
            }
        }
        return (dividend < 0) ^ (divisor < 0) ? (int) -quotient : (int) quotient;
    }
}

