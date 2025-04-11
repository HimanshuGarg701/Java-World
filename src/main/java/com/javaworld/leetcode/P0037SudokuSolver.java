package com.javaworld.leetcode;

public class P0037SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        int chosenRow = -1, chosenColumn = -1, smallestChoices = 10;
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] != '.') continue;
                int choices = 0;
                for (char digit = '1'; digit <= '9'; digit++) if (valid(board, row, column, digit)) choices++;
                if (choices < smallestChoices) {
                    smallestChoices = choices;
                    chosenRow = row;
                    chosenColumn = column;
                }
            }
        }
        if (chosenRow == -1) return true;
        for (char digit = '1'; digit <= '9'; digit++) {
            if (!valid(board, chosenRow, chosenColumn, digit)) continue;
            board[chosenRow][chosenColumn] = digit;
            if (solve(board)) return true;
            board[chosenRow][chosenColumn] = '.';
        }
        return false;
    }

    private boolean valid(char[][] board, int row, int column, char digit) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit || board[i][column] == digit) return false;
            int boxRow = row / 3 * 3 + i / 3;
            int boxColumn = column / 3 * 3 + i % 3;
            if (board[boxRow][boxColumn] == digit) return false;
        }
        return true;
    }
}

