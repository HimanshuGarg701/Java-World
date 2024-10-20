package com.javaworld.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class P0346MovingAverageFromDataStream {
    private final int capacity;
    private final Queue<Integer> window = new ArrayDeque<>();
    private long sum;

    public P0346MovingAverageFromDataStream(int size) {
        capacity = size;
    }

    public double next(int value) {
        window.add(value);
        sum += value;
        if (window.size() > capacity) sum -= window.remove();
        return (double) sum / window.size();
    }
}
