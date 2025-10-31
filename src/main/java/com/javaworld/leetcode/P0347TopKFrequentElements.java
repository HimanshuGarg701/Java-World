package com.javaworld.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P0347TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int value : nums) frequencies.put(value, frequencies.getOrDefault(value, 0) + 1);
        PriorityQueue<Integer> heap = new PriorityQueue<>((first, second) ->
                Integer.compare(frequencies.get(first), frequencies.get(second)));
        for (int value : frequencies.keySet()) {
            heap.add(value);
            if (heap.size() > k) heap.remove();
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) result[i] = heap.remove();
        return result;
    }
}
