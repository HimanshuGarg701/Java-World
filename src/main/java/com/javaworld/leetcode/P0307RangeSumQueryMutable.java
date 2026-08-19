package com.javaworld.leetcode;

public class P0307RangeSumQueryMutable {
    private final int[] values;
    private final int[] tree;

    public P0307RangeSumQueryMutable(int[] nums) {
        values = nums.clone();
        tree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) add(i + 1, nums[i]);
    }

    public void update(int index, int value) {
        int difference = value - values[index];
        values[index] = value;
        add(index + 1, difference);
    }

    public int sumRange(int left, int right) {
        return prefix(right + 1) - prefix(left);
    }

    private void add(int index, int value) {
        for (int i = index; i < tree.length; i += i & -i) tree[i] += value;
    }

    private int prefix(int index) {
        int sum = 0;
        for (int i = index; i > 0; i -= i & -i) sum += tree[i];
        return sum;
    }
}
