package leetcode;

import dataStructure.ListNode;

public class RotateList {

	// method 1: calculate length first, move to the end node, do the rotation
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode node = head;
        int len = 1;
        while (node.next != null){
            node = node.next;
            len++;
        }
        node.next = head; // make a circular list
        
        int shift = k % len;
        node = head;
        for (int count = 1; count < (len - shift); count++){
            node = node.next;
        }
        
        ListNode newHead = node.next;
        node.next = null;
        return newHead;
    }
}
