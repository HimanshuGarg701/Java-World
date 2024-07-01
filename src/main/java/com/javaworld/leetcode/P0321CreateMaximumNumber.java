package com.javaworld.leetcode;

public class P0321CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] best = new int[k];
        boolean initialized = false;
        int minimumFirst = Math.max(0, k - nums2.length);
        int maximumFirst = Math.min(k, nums1.length);
        for (int firstLength = minimumFirst; firstLength <= maximumFirst; firstLength++) {
            int[] first = maximumSubsequence(nums1, firstLength);
            int[] second = maximumSubsequence(nums2, k - firstLength);
            int[] candidate = merge(first, second);
            if (!initialized || greater(candidate, 0, best, 0)) {
                best = candidate;
                initialized = true;
            }
        }
        return best;
    }

    private int[] maximumSubsequence(int[] nums, int length) {
        int[] stack = new int[length];
        int size = 0;
        int removable = nums.length - length;
        for (int value : nums) {
            while (size > 0 && removable > 0 && stack[size - 1] < value) {
                size--;
                removable--;
            }
            if (size < length) stack[size++] = value;
            else removable--;
        }
        return stack;
    }

    private int[] merge(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        for (int position = 0; position < result.length; position++) {
            if (greater(first, i, second, j)) result[position] = first[i++];
            else result[position] = second[j++];
        }
        return result;
    }

    private boolean greater(int[] first, int i, int[] second, int j) {
        while (i < first.length && j < second.length && first[i] == second[j]) {
            i++;
            j++;
        }
        return j == second.length || (i < first.length && first[i] > second[j]);
    }
}
