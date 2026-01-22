package com.javaworld.leetcode;

public class P0329LongestIncreasingPathInAMatrix {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        int best = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                best = Math.max(best, search(matrix, memo, row, column));
            }
        }
        return best;
    }

    private int search(int[][] matrix, int[][] memo, int row, int column) {
        if (memo[row][column] != 0) return memo[row][column];
        int best = 1;
        for (int[] direction : DIRECTIONS) {
            int nextRow = row + direction[0];
            int nextColumn = column + direction[1];
            if (nextRow >= 0 && nextRow < matrix.length && nextColumn >= 0
                    && nextColumn < matrix[0].length
                    && matrix[nextRow][nextColumn] > matrix[row][column]) {
                best = Math.max(best, 1 + search(matrix, memo, nextRow, nextColumn));
            }
        }
        memo[row][column] = best;
        return best;
    }
}
