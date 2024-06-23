package com.javaworld.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class P0210CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int course = 0; course < numCourses; course++) graph.add(new ArrayList<>());
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        Queue<Integer> ready = new ArrayDeque<>();
        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) ready.add(course);
        }
        int[] order = new int[numCourses];
        int index = 0;
        while (!ready.isEmpty()) {
            int course = ready.remove();
            order[index++] = course;
            for (int next : graph.get(course)) {
                if (--indegree[next] == 0) ready.add(next);
            }
        }
        return index == numCourses ? order : new int[0];
    }
}
