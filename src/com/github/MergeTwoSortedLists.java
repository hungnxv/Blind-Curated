package com.github;

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();

        ListNode first = l1;
        ListNode second = l2;
        ListNode current = result;
        while (first.next != null || second.next != null) {

            if(first == null) {
                while (second != null) {
                    result.next = second;
                    second = second.next;
                }
                break;

            }

            if(second == null) {
                while (first != null) {
                    result.next = first;
                    first = first.next;
                }
                break;
            }

            
            int val1=  first.val;
            int val2 = second.val;

            if(val1 < val2) {
                result.next = first;
                first = first.next;
            }
            else {
                result.next = second;
                second = second.next;
            }
        }

        return result.next;
    }


    public static class ListNode {
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
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);

        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        ListNode node11 = new ListNode(11);

        node1.next =node3;
        node3.next =node4;
        node4.next =node7;
        node7.next =node11;

        node2.next =node5;
        node5.next =node6;
        node6.next =node8;
        node8.next =node9;
        node9.next =node10;

        ListNode result = mergeTwoLists(node1, node2);
        ListNode current = result;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.print("]");


    }

}

