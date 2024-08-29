package com.javaworld.leetcode;

import java.util.HashSet;
import java.util.Set;

public class P0217ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int number : nums) {
            if (!seen.add(number)) return true;
        }
        return false;
    }
}
