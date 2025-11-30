package com.javaworld.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P0023MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode list : lists) if (list != null) queue.offer(list);
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null) queue.offer(tail.next);
        }
        return dummy.next;
    }
}

