package com.github;

import java.util.PriorityQueue;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 */
public class MergeKSortedLists {

  public static ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1, n2) -> {
      if (n1.val > n2.val) {
        return 1;
      } else if (n1.val < n2.val) {
        return -1;
      } else {
        return 0;
      }
    });

    ListNode current = null;
    for (int i = 0; i < lists.length; i++) {
      current = lists[i];
      while (current != null) {
        minHeap.add(current);
        current = current.next;
      }

    }

    current = minHeap.poll();
    ListNode result = current;
    while (current != null) {

      current.next = minHeap.poll();
      current = current.next;


    }
    return result;

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

    //[[1,4,5],[1,3,4],[2,6]]
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(4);
    ListNode listNode3 = new ListNode(5);
    listNode1.next = listNode2;
    listNode2.next = listNode3;

    ListNode listNode4 = new ListNode(1);

    ListNode listNode5= new ListNode(3);
    ListNode listNode6= new ListNode(4);
    listNode4.next = listNode5;
    listNode5.next = listNode6;

    ListNode listNode7= new ListNode(2);
    ListNode listNode8= new ListNode(6);
    listNode7.next = listNode8;
    ListNode[] lists = new ListNode[3];
    lists[0] = listNode1;
    lists[1] = listNode4;
    lists[2] = listNode7;

    ListNode result = mergeKLists(lists);
    while (result != null) {
      System.out.println(result.val);
      result = result.next;
    }

  }

}
