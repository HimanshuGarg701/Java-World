package com.javaworld.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P0325MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Long, Integer> firstIndex = new HashMap<>();
        firstIndex.put(0L, -1);
        long prefix = 0;
        int best = 0;
        for (int index = 0; index < nums.length; index++) {
            prefix += nums[index];
            Integer start = firstIndex.get(prefix - k);
            if (start != null) best = Math.max(best, index - start);
            firstIndex.putIfAbsent(prefix, index);
        }
        return best;
    }
}
