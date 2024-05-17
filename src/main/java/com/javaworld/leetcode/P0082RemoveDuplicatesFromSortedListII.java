package com.javaworld.leetcode;

public class P0082RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode previous = dummy;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                int duplicate = head.val;
                while (head != null && head.val == duplicate) head = head.next;
                previous.next = head;
            } else {
                previous = head;
                head = head.next;
            }
        }
        return dummy.next;
    }
}

