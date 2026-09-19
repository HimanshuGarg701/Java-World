package com.javaworld.leetcode;

public class P0053MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int endingHere = nums[0], best = nums[0];
        for (int i = 1; i < nums.length; i++) {
            endingHere = Math.max(nums[i], endingHere + nums[i]);
            best = Math.max(best, endingHere);
        }
        return best;
    }
}

