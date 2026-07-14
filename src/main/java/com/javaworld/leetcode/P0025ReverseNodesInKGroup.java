package com.javaworld.leetcode;

public class P0025ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupBefore = dummy;
        while (true) {
            ListNode kth = groupBefore;
            for (int i = 0; i < k && kth != null; i++) kth = kth.next;
            if (kth == null) break;
            ListNode groupAfter = kth.next;
            ListNode previous = groupAfter;
            ListNode current = groupBefore.next;
            while (current != groupAfter) {
                ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            ListNode oldStart = groupBefore.next;
            groupBefore.next = kth;
            groupBefore = oldStart;
        }
        return dummy.next;
    }
}

