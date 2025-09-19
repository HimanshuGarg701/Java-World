package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P0090SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int previousStart = 0;
        for (int i = 0; i < nums.length; i++) {
            int oldSize = result.size();
            int start = i > 0 && nums[i] == nums[i - 1] ? previousStart : 0;
            for (int j = start; j < oldSize; j++) {
                List<Integer> subset = new ArrayList<>(result.get(j));
                subset.add(nums[i]);
                result.add(subset);
            }
            previousStart = oldSize;
        }
        return result;
    }
}

