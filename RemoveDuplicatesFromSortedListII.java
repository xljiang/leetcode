package leetcode;

import dataStructure.ListNode;

public class RemoveDuplicatesFromSortedListII {

	// method 1
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        
        ListNode newHead = new ListNode(-10101);
        newHead.next = head;
        
        boolean del = false;
        ListNode pre = newHead, curr = head, nn = curr.next;
        
        while (nn != null){
            if (nn.val == curr.val){
                del = true;
                curr.next = nn.next;
            } else{
                if (del){ // the curr node need to be deleted (here the curr node won't be the last node)
                    pre.next = curr.next;
                    curr = pre.next;
                    del = false;
                } else{
                    pre = pre.next;
                    curr = curr.next;
                }
            }
            nn = curr.next;
            
            // if the last digit need to be deleted
            if (del && curr.next == null){
                pre.next = null;
            }
        }
        return newHead.next;
    }
    
    //method 2: better than method 1
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null){
            return null;
        }
        
        ListNode newHead = new ListNode(-10101);
        newHead.next = head;
        
        ListNode pre = newHead, curr = head;
        
        while (curr != null){
            while (curr.next != null && curr.val == curr.next.val){
                curr = curr.next;
            }
            if (pre.next == curr){
                pre = pre.next;
            } else{
                pre.next = curr.next;
            }
            curr = pre.next;
        }
        return newHead.next;
    }
}
