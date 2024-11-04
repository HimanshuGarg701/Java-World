package com.javaworld.leetcode;

public class P0073SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false, firstColumn = false;
        for (int row = 0; row < matrix.length; row++) if (matrix[row][0] == 0) firstColumn = true;
        for (int column = 0; column < matrix[0].length; column++) if (matrix[0][column] == 0) firstRow = true;
        for (int row = 1; row < matrix.length; row++) {
            for (int column = 1; column < matrix[0].length; column++) {
                if (matrix[row][column] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][column] = 0;
                }
            }
        }
        for (int row = 1; row < matrix.length; row++) {
            for (int column = 1; column < matrix[0].length; column++) {
                if (matrix[row][0] == 0 || matrix[0][column] == 0) matrix[row][column] = 0;
            }
        }
        if (firstRow) for (int column = 0; column < matrix[0].length; column++) matrix[0][column] = 0;
        if (firstColumn) for (int row = 0; row < matrix.length; row++) matrix[row][0] = 0;
    }
}

