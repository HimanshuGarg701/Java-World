package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P0057InsertInterval {
    public int[][] insert(int[][] intervals, int[] added) {
        List<int[]> result = new ArrayList<>();
        int index = 0;
        while (index < intervals.length && intervals[index][1] < added[0]) result.add(intervals[index++]);
        while (index < intervals.length && intervals[index][0] <= added[1]) {
            added[0] = Math.min(added[0], intervals[index][0]);
            added[1] = Math.max(added[1], intervals[index++][1]);
        }
        result.add(added);
        while (index < intervals.length) result.add(intervals[index++]);
        return result.toArray(int[][]::new);
    }
}

