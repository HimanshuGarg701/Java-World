package com.javaworld.leetcode;

import java.util.PriorityQueue;

public class P0215KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> largest = new PriorityQueue<>();
        for (int number : nums) {
            largest.add(number);
            if (largest.size() > k) largest.remove();
        }
        return largest.element();
    }
}
