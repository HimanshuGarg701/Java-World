package com.javaworld.leetcode;

public class P0064MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int[] cost = new int[grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (row == 0 && column == 0) cost[column] = grid[row][column];
                else if (row == 0) cost[column] = cost[column - 1] + grid[row][column];
                else if (column == 0) cost[column] += grid[row][column];
                else cost[column] = Math.min(cost[column], cost[column - 1]) + grid[row][column];
            }
        }
        return cost[cost.length - 1];
    }
}

