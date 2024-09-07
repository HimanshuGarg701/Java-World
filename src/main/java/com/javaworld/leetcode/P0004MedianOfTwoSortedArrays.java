package com.javaworld.leetcode;

public class P0004MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length > b.length) return findMedianSortedArrays(b, a);
        int leftSize = (a.length + b.length + 1) / 2;
        int low = 0, high = a.length;
        while (low <= high) {
            int cutA = (low + high) >>> 1;
            int cutB = leftSize - cutA;
            int leftA = cutA == 0 ? Integer.MIN_VALUE : a[cutA - 1];
            int rightA = cutA == a.length ? Integer.MAX_VALUE : a[cutA];
            int leftB = cutB == 0 ? Integer.MIN_VALUE : b[cutB - 1];
            int rightB = cutB == b.length ? Integer.MAX_VALUE : b[cutB];
            if (leftA <= rightB && leftB <= rightA) {
                if (((a.length + b.length) & 1) == 1) return Math.max(leftA, leftB);
                return ((double) Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2;
            }
            if (leftA > rightB) high = cutA - 1;
            else low = cutA + 1;
        }
        throw new IllegalArgumentException("Inputs must be sorted");
    }
}

