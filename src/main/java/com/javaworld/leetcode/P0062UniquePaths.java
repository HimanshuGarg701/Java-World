package com.javaworld.leetcode;

public class P0062UniquePaths {
    public int uniquePaths(int rows, int columns) {
        int[] paths = new int[columns];
        for (int column = 0; column < columns; column++) paths[column] = 1;
        for (int row = 1; row < rows; row++) {
            for (int column = 1; column < columns; column++) paths[column] += paths[column - 1];
        }
        return paths[columns - 1];
    }
}

