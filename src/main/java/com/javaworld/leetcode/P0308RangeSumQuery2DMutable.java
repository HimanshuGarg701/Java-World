package com.javaworld.leetcode;

public class P0308RangeSumQuery2DMutable {
    private final int[][] values;
    private final int[][] tree;
    private final int rows;
    private final int columns;

    public P0308RangeSumQuery2DMutable(int[][] matrix) {
        rows = matrix.length;
        columns = rows == 0 ? 0 : matrix[0].length;
        values = new int[rows][columns];
        tree = new int[rows + 1][columns + 1];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) update(row, column, matrix[row][column]);
        }
    }

    public void update(int row, int col, int value) {
        int difference = value - values[row][col];
        values[row][col] = value;
        for (int r = row + 1; r <= rows; r += r & -r) {
            for (int c = col + 1; c <= columns; c += c & -c) tree[r][c] += difference;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix(row2 + 1, col2 + 1) - prefix(row1, col2 + 1)
                - prefix(row2 + 1, col1) + prefix(row1, col1);
    }

    private int prefix(int row, int column) {
        int sum = 0;
        for (int r = row; r > 0; r -= r & -r) {
            for (int c = column; c > 0; c -= c & -c) sum += tree[r][c];
        }
        return sum;
    }
}
