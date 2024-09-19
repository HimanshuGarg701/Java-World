package com.javaworld.leetcode;

public class P0092ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode before = dummy;
        for (int position = 1; position < left; position++) before = before.next;
        ListNode start = before.next;
        for (int position = left; position < right; position++) {
            ListNode moved = start.next;
            start.next = moved.next;
            moved.next = before.next;
            before.next = moved;
        }
        return dummy.next;
    }
}

