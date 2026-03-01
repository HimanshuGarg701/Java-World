package com.javaworld.leetcode;

import java.util.HashSet;
import java.util.Set;

public class P0349IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> first = new HashSet<>();
        for (int value : nums1) first.add(value);
        Set<Integer> common = new HashSet<>();
        for (int value : nums2) if (first.contains(value)) common.add(value);
        return common.stream().mapToInt(Integer::intValue).toArray();
    }
}
