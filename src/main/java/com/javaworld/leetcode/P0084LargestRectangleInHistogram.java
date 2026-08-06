package com.javaworld.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P0084LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> increasing = new ArrayDeque<>();
        int best = 0;
        for (int i = 0; i <= heights.length; i++) {
            int current = i == heights.length ? 0 : heights[i];
            while (!increasing.isEmpty() && heights[increasing.peek()] > current) {
                int height = heights[increasing.pop()];
                int left = increasing.isEmpty() ? -1 : increasing.peek();
                best = Math.max(best, height * (i - left - 1));
            }
            increasing.push(i);
        }
        return best;
    }
}

