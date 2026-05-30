package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P0078Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int number : nums) {
            int existing = result.size();
            for (int i = 0; i < existing; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(number);
                result.add(subset);
            }
        }
        return result;
    }
}

