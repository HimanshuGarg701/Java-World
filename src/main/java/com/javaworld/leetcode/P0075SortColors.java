package com.javaworld.leetcode;

public class P0075SortColors {
    public void sortColors(int[] nums) {
        int red = 0, current = 0, blue = nums.length - 1;
        while (current <= blue) {
            if (nums[current] == 0) swap(nums, red++, current++);
            else if (nums[current] == 2) swap(nums, current, blue--);
            else current++;
        }
    }

    private void swap(int[] nums, int first, int second) {
        int value = nums[first];
        nums[first] = nums[second];
        nums[second] = value;
    }
}

