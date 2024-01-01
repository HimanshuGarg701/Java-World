package com.javaworld.leetcode;

public class P0086PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode smallerDummy = new ListNode(), largerDummy = new ListNode();
        ListNode smaller = smallerDummy, larger = largerDummy;
        while (head != null) {
            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                larger.next = head;
                larger = larger.next;
            }
            head = head.next;
        }
        larger.next = null;
        smaller.next = largerDummy.next;
        return smallerDummy.next;
    }
}

