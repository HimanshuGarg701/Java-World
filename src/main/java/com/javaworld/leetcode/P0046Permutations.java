package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P0046Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        arrange(nums, 0, result);
        return result;
    }

    private void arrange(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int number : nums) permutation.add(number);
            result.add(permutation);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            arrange(nums, index + 1, result);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int first, int second) {
        int value = nums[first];
        nums[first] = nums[second];
        nums[second] = value;
    }
}

