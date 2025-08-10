package com.javaworld.leetcode;

public class P0042TrappingRainWater {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMaximum = 0, rightMaximum = 0, water = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                leftMaximum = Math.max(leftMaximum, height[left]);
                water += leftMaximum - height[left++];
            } else {
                rightMaximum = Math.max(rightMaximum, height[right]);
                water += rightMaximum - height[right--];
            }
        }
        return water;
    }
}

