package com.javaworld.leetcode;

public class P0302SmallestRectangleEnclosingBlackPixels {
    public int minArea(char[][] image, int x, int y) {
        int top = image.length;
        int bottom = -1;
        int left = image[0].length;
        int right = -1;
        for (int row = 0; row < image.length; row++) {
            for (int column = 0; column < image[row].length; column++) {
                if (image[row][column] != '1') continue;
                top = Math.min(top, row);
                bottom = Math.max(bottom, row);
                left = Math.min(left, column);
                right = Math.max(right, column);
            }
        }
        return (bottom - top + 1) * (right - left + 1);
    }
}
