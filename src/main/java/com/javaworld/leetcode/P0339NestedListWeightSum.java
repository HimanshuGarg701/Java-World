package com.javaworld.leetcode;

import java.util.List;

public class P0339NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    private int depthSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger value : nestedList) {
            if (value.isInteger()) sum += value.getInteger() * depth;
            else sum += depthSum(value.getList(), depth + 1);
        }
        return sum;
    }
}
