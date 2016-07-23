package leetcode;

import dataStructure.ListNode;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null){
            if (slow == fast){
                return true;
            } else{
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return false;
    }
}
