package com.javaworld.leetcode;

public class P0213HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(robLine(nums, 0, nums.length - 2), robLine(nums, 1, nums.length - 1));
    }

    private int robLine(int[] nums, int start, int end) {
        int previousTwo = 0;
        int previousOne = 0;
        for (int index = start; index <= end; index++) {
            int current = Math.max(previousOne, previousTwo + nums[index]);
            previousTwo = previousOne;
            previousOne = current;
        }
        return previousOne;
    }
}
