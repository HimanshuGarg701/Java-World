package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P0216CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        search(1, k, n, new ArrayList<>(), result);
        return result;
    }

    private void search(
            int next,
            int remainingCount,
            int remainingSum,
            List<Integer> combination,
            List<List<Integer>> result) {
        if (remainingCount == 0) {
            if (remainingSum == 0) result.add(new ArrayList<>(combination));
            return;
        }
        for (int number = next; number <= 9 && number <= remainingSum; number++) {
            combination.add(number);
            search(number + 1, remainingCount - 1, remainingSum - number, combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}
