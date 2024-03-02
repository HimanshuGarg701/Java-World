package com.javaworld.leetcode;

public class P0035SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int middle = (low + high) >>> 1;
            if (nums[middle] < target) low = middle + 1;
            else high = middle;
        }
        return low;
    }
}

