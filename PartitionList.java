package leetcode;

import dataStructure.ListNode;

public class PartitionList {
	
	// method 1: two pointers class 1, one-pass
	public ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode curr = head, lessEnd = newHead, prev = newHead;
        while (curr != null){
            if (curr.val < x ){
                if (prev.val < x){
                    lessEnd = curr;
                    prev = curr;
                    curr = prev.next;
                } else { // prev.val >= x
                    ListNode lessNxt = lessEnd.next;
                    ListNode currNxt = curr.next;
                    lessEnd.next = curr;
                    curr.next = lessNxt;
                    prev.next = currNxt;
                    lessEnd = curr;
                    curr = currNxt;
                }
            } else { // curr.val >= x
                prev = curr;
                curr = prev.next;
            }
        }
        return newHead.next;
    }
	
	// method 2: two pointers class 3, separate the list into two distinct lists and link them together
    public ListNode partition2(ListNode head, int x) {
        ListNode h1 = new ListNode(-10101);
        ListNode h2 = new ListNode(-10101); 
        ListNode node1 = h1, node2 = h2;
        while (head != null){
            if (head.val < x){
                node1.next = head;
                node1 = node1.next;
            } else{
                node2.next = head;
                node2 = node2.next;
            }
            head = head.next;
        }
        node2.next = null; // !!!
        node1.next = h2.next;
        return h1.next;
    }
}
