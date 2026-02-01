package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P0039CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        search(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void search(int[] values, int remaining, int start, List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < values.length && values[i] <= remaining; i++) {
            current.add(values[i]);
            search(values, remaining - values[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}

