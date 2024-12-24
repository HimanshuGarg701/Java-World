package com.javaworld.leetcode;

public class P0311SparseMatrixMultiplication {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int rows = mat1.length;
        int shared = mat1[0].length;
        int columns = mat2[0].length;
        int[][] result = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int middle = 0; middle < shared; middle++) {
                if (mat1[row][middle] == 0) continue;
                for (int column = 0; column < columns; column++) {
                    if (mat2[middle][column] != 0) {
                        result[row][column] += mat1[row][middle] * mat2[middle][column];
                    }
                }
            }
        }
        return result;
    }
}
