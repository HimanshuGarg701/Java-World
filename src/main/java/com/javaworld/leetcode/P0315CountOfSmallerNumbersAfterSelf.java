package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P0315CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        int[] indices = new int[nums.length];
        int[] buffer = new int[nums.length];
        int[] counts = new int[nums.length];
        for (int i = 0; i < nums.length; i++) indices[i] = i;
        mergeSort(nums, indices, buffer, counts, 0, nums.length);
        List<Integer> result = new ArrayList<>(nums.length);
        for (int count : counts) result.add(count);
        return result;
    }

    private void mergeSort(int[] nums, int[] indices, int[] buffer, int[] counts, int left, int right) {
        if (right - left <= 1) return;
        int middle = (left + right) >>> 1;
        mergeSort(nums, indices, buffer, counts, left, middle);
        mergeSort(nums, indices, buffer, counts, middle, right);
        int i = left;
        int j = middle;
        int position = left;
        while (i < middle || j < right) {
            if (j == right || (i < middle && nums[indices[i]] <= nums[indices[j]])) {
                counts[indices[i]] += j - middle;
                buffer[position++] = indices[i++];
            } else {
                buffer[position++] = indices[j++];
            }
        }
        System.arraycopy(buffer, left, indices, left, right - left);
    }
}
