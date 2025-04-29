package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P0060PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> digits = new ArrayList<>();
        int factorial = 1;
        for (int digit = 1; digit <= n; digit++) {
            digits.add(digit);
            if (digit < n) factorial *= digit;
        }
        k--;
        StringBuilder result = new StringBuilder();
        for (int remaining = n; remaining > 0; remaining--) {
            int choice = k / factorial;
            result.append(digits.remove(choice));
            k %= factorial;
            if (remaining > 1) factorial /= remaining - 1;
        }
        return result.toString();
    }
}
