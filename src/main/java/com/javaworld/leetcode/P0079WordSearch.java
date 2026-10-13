package com.javaworld.leetcode;

public class P0079WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (find(board, word, 0, row, column)) return true;
            }
        }
        return false;
    }

    private boolean find(char[][] board, String word, int index, int row, int column) {
        if (index == word.length()) return true;
        if (row < 0 || row == board.length || column < 0 || column == board[0].length ||
                board[row][column] != word.charAt(index)) return false;
        char saved = board[row][column];
        board[row][column] = '\0';
        boolean found = find(board, word, index + 1, row + 1, column) ||
                find(board, word, index + 1, row - 1, column) ||
                find(board, word, index + 1, row, column + 1) ||
                find(board, word, index + 1, row, column - 1);
        board[row][column] = saved;
        return found;
    }
}

