package com.javaworld.leetcode;

public class P0330PatchingArray {
    public int minPatches(int[] nums, int n) {
        long missing = 1;
        int index = 0;
        int patches = 0;
        while (missing <= n) {
            if (index < nums.length && nums[index] <= missing) missing += nums[index++];
            else {
                missing += missing;
                patches++;
            }
        }
        return patches;
    }
}
