package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P0332ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), ignored -> new PriorityQueue<>()).add(ticket.get(1));
        }
        LinkedList<String> itinerary = new LinkedList<>();
        visit("JFK", graph, itinerary);
        return new ArrayList<>(itinerary);
    }

    private void visit(String airport, Map<String, PriorityQueue<String>> graph, LinkedList<String> itinerary) {
        PriorityQueue<String> destinations = graph.get(airport);
        while (destinations != null && !destinations.isEmpty()) visit(destinations.remove(), graph, itinerary);
        itinerary.addFirst(airport);
    }
}
