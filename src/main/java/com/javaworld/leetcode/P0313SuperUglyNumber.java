package com.javaworld.leetcode;

public class P0313SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] ugly = new long[n];
        ugly[0] = 1;
        int[] indices = new int[primes.length];
        long[] candidates = new long[primes.length];
        for (int i = 0; i < primes.length; i++) candidates[i] = primes[i];
        for (int position = 1; position < n; position++) {
            long next = candidates[0];
            for (long candidate : candidates) next = Math.min(next, candidate);
            ugly[position] = next;
            for (int i = 0; i < primes.length; i++) {
                if (candidates[i] == next) {
                    indices[i]++;
                    candidates[i] = ugly[indices[i]] * primes[i];
                }
            }
        }
        return (int) ugly[n - 1];
    }
}
