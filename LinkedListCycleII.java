package leetcode;

import dataStructure.ListNode;

public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        
        // find meeting point
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){ // collision
                break;
            }
        }
        
        // error check - no meeting point, and therefore no loop
        if (fast == null || fast.next == null){
            return null;
        }
        
        // move slow to head. keep fast at meeting point.
        // move slow and fast at the same pace, they'll meet at the loop start
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
