package com.javaworld.leetcode;

public class P0348DesignTicTacToe {
    private final int[] rows;
    private final int[] columns;
    private final int size;
    private int diagonal;
    private int antiDiagonal;

    public P0348DesignTicTacToe(int n) {
        size = n;
        rows = new int[n];
        columns = new int[n];
    }

    public int move(int row, int col, int player) {
        int value = player == 1 ? 1 : -1;
        rows[row] += value;
        columns[col] += value;
        if (row == col) diagonal += value;
        if (row + col == size - 1) antiDiagonal += value;
        if (Math.abs(rows[row]) == size || Math.abs(columns[col]) == size
                || Math.abs(diagonal) == size || Math.abs(antiDiagonal) == size) return player;
        return 0;
    }
}
