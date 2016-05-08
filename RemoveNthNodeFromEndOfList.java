package leetcode;

import dataStructure.ListNode;

public class RemoveNthNodeFromEndOfList {

	// method 1: two-pass
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return null;
        }
        int len = 1;
        ListNode tmp = head;
        while (tmp.next != null){
            len++;
            tmp = tmp.next;
        }
        
        if (n > len){ // invalid n
            return null;
        } else if (n == len){
            return head.next;
        } else{
            ListNode node = head;
            for (int i = 1; i < len - n; i++){
                node = node.next;
            }
            node.next = node.next.next;
        }
        return head;
    }
    
    // method 2: two pointers and dummy head
    // input n must be valid (no check of invalid n in this solution)
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        
        ListNode fast = newHead, slow = newHead;
        
        // move fast pointer first so that the gap between fast and slow is n
        for( int count = 0; count < n; count++){
            fast = fast.next;
        }
        
        // move fast and slow pointer together to the end of the list
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }
}
