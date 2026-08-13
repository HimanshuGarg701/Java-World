package com.javaworld.leetcode;

public class P0055JumpGame {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length && i <= farthest; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length - 1) return true;
        }
        return nums.length == 0;
    }
}

