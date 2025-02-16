package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P0218TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();
        for (int[] building : buildings) {
            events.add(new int[]{building[0], -building[2], building[1]});
            events.add(new int[]{building[1], 0, 0});
        }
        events.sort(Comparator.comparingInt((int[] event) -> event[0])
                .thenComparingInt(event -> event[1]));
        PriorityQueue<int[]> active = new PriorityQueue<>((first, second) ->
                first[0] == second[0]
                        ? Integer.compare(second[1], first[1])
                        : Integer.compare(second[0], first[0]));
        active.add(new int[]{0, Integer.MAX_VALUE});
        List<List<Integer>> skyline = new ArrayList<>();
        int previousHeight = 0;
        int index = 0;
        while (index < events.size()) {
            int x = events.get(index)[0];
            while (index < events.size() && events.get(index)[0] == x) {
                int[] event = events.get(index++);
                if (event[1] < 0) active.add(new int[]{-event[1], event[2]});
            }
            while (active.size() > 1 && active.element()[1] <= x) active.remove();
            int height = active.element()[0];
            if (height != previousHeight) {
                skyline.add(Arrays.asList(x, height));
                previousHeight = height;
            }
        }
        return skyline;
    }
}
