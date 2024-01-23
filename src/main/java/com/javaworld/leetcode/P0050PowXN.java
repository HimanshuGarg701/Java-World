package com.javaworld.leetcode;

public class P0050PowXN {
    public double myPow(double base, int exponent) {
        long power = exponent;
        if (power < 0) {
            base = 1 / base;
            power = -power;
        }
        double result = 1;
        while (power > 0) {
            if ((power & 1) == 1) result *= base;
            base *= base;
            power >>= 1;
        }
        return result;
    }
}

