package com.javaworld.leetcode;

public class P0080RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int write = 0;
        for (int number : nums) {
            if (write < 2 || number != nums[write - 2]) nums[write++] = number;
        }
        return write;
    }
}
