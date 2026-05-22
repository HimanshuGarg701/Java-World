package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P0077Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        choose(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void choose(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        int needed = k - current.size();
        for (int value = start; value <= n - needed + 1; value++) {
            current.add(value);
            choose(value + 1, n, k, current, result);
            current.remove(current.size() - 1);
        }
    }
}

