package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P0056MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (first, second) -> Integer.compare(first[0], second[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval.clone());
            } else {
                int[] previous = merged.get(merged.size() - 1);
                previous[1] = Math.max(previous[1], interval[1]);
            }
        }
        return merged.toArray(int[][]::new);
    }
}

