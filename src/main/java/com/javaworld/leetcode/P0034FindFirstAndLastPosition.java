package com.javaworld.leetcode;

public class P0034FindFirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int first = boundary(nums, target);
        if (first == nums.length || nums[first] != target) return new int[]{-1, -1};
        return new int[]{first, boundary(nums, target + 1L) - 1};
    }

    private int boundary(int[] nums, long target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int middle = (low + high) >>> 1;
            if (nums[middle] < target) low = middle + 1;
            else high = middle;
        }
        return low;
    }
}

