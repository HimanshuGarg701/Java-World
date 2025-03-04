package com.javaworld.leetcode;

public class P0085MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[] heights = new int[matrix[0].length];
        int best = 0;
        P0084LargestRectangleInHistogram histogram = new P0084LargestRectangleInHistogram();
        for (char[] row : matrix) {
            for (int column = 0; column < row.length; column++) {
                heights[column] = row[column] == '0' ? 0 : heights[column] + 1;
            }
            best = Math.max(best, histogram.largestRectangleArea(heights));
        }
        return best;
    }
}

