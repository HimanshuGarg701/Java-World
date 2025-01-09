package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P0047PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        choose(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    private void choose(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            used[i] = true;
            current.add(nums[i]);
            choose(nums, used, current, result);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}

