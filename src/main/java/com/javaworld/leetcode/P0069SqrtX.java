package com.javaworld.leetcode;

public class P0069SqrtX {
    public int mySqrt(int x) {
        int low = 0, high = Math.min(x, 46_340), answer = 0;
        while (low <= high) {
            int middle = (low + high) >>> 1;
            if ((long) middle * middle <= x) {
                answer = middle;
                low = middle + 1;
            } else high = middle - 1;
        }
        return answer;
    }
}

