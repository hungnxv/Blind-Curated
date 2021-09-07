package com.github;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class RemoveNthNodeFromEndofList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode fastPointer = dummyHead;
        ListNode slowPointer = dummyHead;

        while (fastPointer  != null) {
            fastPointer = fastPointer.next;
            if(n-- < 0)
                slowPointer = slowPointer.next;
        }

        slowPointer.next = slowPointer.next.next;

        return dummyHead.next;

    }

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{ val=" + val + "}";
        }
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode result = removeNthFromEnd(node1, 1);
        ListNode current = result;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.print("]");


    }

}
