package com.javaworld.leetcode;

public class P0312BurstBalloons {
    public int maxCoins(int[] nums) {
        int[] balloons = new int[nums.length + 2];
        balloons[0] = balloons[balloons.length - 1] = 1;
        System.arraycopy(nums, 0, balloons, 1, nums.length);
        int[][] best = new int[balloons.length][balloons.length];
        for (int width = 2; width < balloons.length; width++) {
            for (int left = 0; left + width < balloons.length; left++) {
                int right = left + width;
                for (int last = left + 1; last < right; last++) {
                    best[left][right] = Math.max(best[left][right],
                            best[left][last] + best[last][right]
                                    + balloons[left] * balloons[last] * balloons[right]);
                }
            }
        }
        return best[0][balloons.length - 1];
    }
}
