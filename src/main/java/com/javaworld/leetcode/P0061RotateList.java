package com.javaworld.leetcode;

public class P0061RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        k %= length;
        if (k == 0) return head;
        tail.next = head;
        int stepsToNewTail = length - k - 1;
        ListNode newTail = head;
        while (stepsToNewTail-- > 0) newTail = newTail.next;
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}

