package com.javaworld.leetcode;

public class P0059SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1, value = 1;
        while (top <= bottom) {
            for (int column = left; column <= right; column++) matrix[top][column] = value++;
            top++;
            for (int row = top; row <= bottom; row++) matrix[row][right] = value++;
            right--;
            for (int column = right; column >= left; column--) matrix[bottom][column] = value++;
            bottom--;
            for (int row = bottom; row >= top; row--) matrix[row][left] = value++;
            left++;
        }
        return matrix;
    }
}

