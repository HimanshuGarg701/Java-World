package com.javaworld.leetcode;

public class P0327CountOfRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefix = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) prefix[i + 1] = prefix[i] + nums[i];
        return (int) count(prefix, new long[prefix.length], 0, prefix.length, lower, upper);
    }

    private long count(long[] sums, long[] buffer, int left, int right, int lower, int upper) {
        if (right - left <= 1) return 0;
        int middle = (left + right) >>> 1;
        long result = count(sums, buffer, left, middle, lower, upper)
                + count(sums, buffer, middle, right, lower, upper);
        int minimum = middle;
        int maximum = middle;
        for (int i = left; i < middle; i++) {
            while (minimum < right && sums[minimum] - sums[i] < lower) minimum++;
            while (maximum < right && sums[maximum] - sums[i] <= upper) maximum++;
            result += maximum - minimum;
        }
        int first = left;
        int second = middle;
        int position = left;
        while (first < middle || second < right) {
            if (second == right || (first < middle && sums[first] <= sums[second])) {
                buffer[position++] = sums[first++];
            } else {
                buffer[position++] = sums[second++];
            }
        }
        System.arraycopy(buffer, left, sums, left, right - left);
        return result;
    }
}
