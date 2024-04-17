package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P0051NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        place(0, board, new boolean[n], new boolean[2 * n], new boolean[2 * n], result);
        return result;
    }

    private void place(int row, char[][] board, boolean[] columns, boolean[] descending,
                       boolean[] ascending, List<List<String>> result) {
        if (row == board.length) {
            List<String> arrangement = new ArrayList<>();
            for (char[] line : board) arrangement.add(new String(line));
            result.add(arrangement);
            return;
        }
        for (int column = 0; column < board.length; column++) {
            int down = row - column + board.length;
            int up = row + column;
            if (columns[column] || descending[down] || ascending[up]) continue;
            columns[column] = descending[down] = ascending[up] = true;
            board[row][column] = 'Q';
            place(row + 1, board, columns, descending, ascending, result);
            board[row][column] = '.';
            columns[column] = descending[down] = ascending[up] = false;
        }
    }
}

