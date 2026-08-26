package com.javaworld.leetcode;

public class P0027RemoveElement {
    public int removeElement(int[] nums, int value) {
        int write = 0;
        for (int number : nums) if (number != value) nums[write++] = number;
        return write;
    }
}

