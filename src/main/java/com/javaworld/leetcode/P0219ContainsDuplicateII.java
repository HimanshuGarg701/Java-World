package com.javaworld.leetcode;

import java.util.HashSet;
import java.util.Set;

public class P0219ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        for (int index = 0; index < nums.length; index++) {
            if (index > k) window.remove(nums[index - k - 1]);
            if (!window.add(nums[index])) return true;
        }
        return false;
    }
}
