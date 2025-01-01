package com.javaworld.leetcode;

public class P0031NextPermutation {
    public void nextPermutation(int[] nums) {
        int pivot = nums.length - 2;
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) pivot--;
        if (pivot >= 0) {
            int swap = nums.length - 1;
            while (nums[swap] <= nums[pivot]) swap--;
            exchange(nums, pivot, swap);
        }
        for (int left = pivot + 1, right = nums.length - 1; left < right; left++, right--) {
            exchange(nums, left, right);
        }
    }

    private void exchange(int[] nums, int first, int second) {
        int value = nums[first];
        nums[first] = nums[second];
        nums[second] = value;
    }
}

