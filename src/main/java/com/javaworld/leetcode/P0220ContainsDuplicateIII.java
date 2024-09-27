package com.javaworld.leetcode;

import java.util.TreeSet;

public class P0220ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (indexDiff <= 0 || valueDiff < 0) return false;
        TreeSet<Long> window = new TreeSet<>();
        for (int index = 0; index < nums.length; index++) {
            long value = nums[index];
            Long candidate = window.ceiling(value - valueDiff);
            if (candidate != null && candidate <= value + valueDiff) return true;
            window.add(value);
            if (index >= indexDiff) window.remove((long) nums[index - indexDiff]);
        }
        return false;
    }
}
