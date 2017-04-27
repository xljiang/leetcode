package leetcode;

import dataStructure.ListNode;

public class SwapNodesInPairs {

	// method 1: 3 pointers, constant space
    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }
        
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode curr = newHead, first = head, second = first.next;
        while (second != null){
            first.next = second.next;
            curr.next = second;
            second.next = first;
            curr = first;
            first = first.next;
            if (first == null){
                break;
            }
            second = first.next;
        }
        return newHead.next;
        
    }
    
    // a clearer version of method 1
    public ListNode swapPairs2(ListNode head) {
        if (head == null){
            return null;
        }
        
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode curr = newHead;
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = first.next;
            first.next = second.next;
            curr.next = second;
            second.next = first;
            curr = first;
        }
        return newHead.next;
    }
	
    
    // method 2: recursive, O(n) space
    public ListNode swapPairs3(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode n = head.next;
        head.next = swapPairs3(head.next.next);
        n.next = head;
        return n;
    }
}
