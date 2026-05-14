package com.javaworld.leetcode;

import java.util.Arrays;

public class P0350IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int first = 0;
        int second = 0;
        int size = 0;
        while (first < nums1.length && second < nums2.length) {
            if (nums1[first] < nums2[second]) first++;
            else if (nums1[first] > nums2[second]) second++;
            else {
                result[size++] = nums1[first++];
                second++;
            }
        }
        return Arrays.copyOf(result, size);
    }
}
