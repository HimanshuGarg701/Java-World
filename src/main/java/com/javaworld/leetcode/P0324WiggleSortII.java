package com.javaworld.leetcode;

import java.util.Arrays;

public class P0324WiggleSortII {
    public void wiggleSort(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int lower = (nums.length - 1) / 2;
        int upper = nums.length - 1;
        for (int index = 0; index < nums.length; index++) {
            nums[index] = index % 2 == 0 ? sorted[lower--] : sorted[upper--];
        }
    }
}
