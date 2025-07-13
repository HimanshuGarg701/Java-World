package com.javaworld.leetcode;

public class P0334IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int value : nums) {
            if (value <= first) first = value;
            else if (value <= second) second = value;
            else return true;
        }
        return false;
    }
}
