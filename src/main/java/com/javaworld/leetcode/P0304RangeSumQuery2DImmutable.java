package com.javaworld.leetcode;

public class P0304RangeSumQuery2DImmutable {
    private final int[][] prefix;

    public P0304RangeSumQuery2DImmutable(int[][] matrix) {
        int rows = matrix.length;
        int columns = rows == 0 ? 0 : matrix[0].length;
        prefix = new int[rows + 1][columns + 1];
        for (int row = 1; row <= rows; row++) {
            for (int column = 1; column <= columns; column++) {
                prefix[row][column] = matrix[row - 1][column - 1]
                        + prefix[row - 1][column] + prefix[row][column - 1]
                        - prefix[row - 1][column - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1] - prefix[row1][col2 + 1]
                - prefix[row2 + 1][col1] + prefix[row1][col1];
    }
}
