package com.javaworld.leetcode;

public class P0036ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] == '.') continue;
                int digit = board[row][column] - '1';
                int box = row / 3 * 3 + column / 3;
                if (rows[row][digit] || columns[column][digit] || boxes[box][digit]) return false;
                rows[row][digit] = columns[column][digit] = boxes[box][digit] = true;
            }
        }
        return true;
    }
}

