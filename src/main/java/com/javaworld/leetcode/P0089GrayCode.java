package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P0089GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>(1 << n);
        for (int value = 0; value < (1 << n); value++) result.add(value ^ (value >> 1));
        return result;
    }
}

