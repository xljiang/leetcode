package leetcode;

import dataStructure.ListNode;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head, nn = head.next; // nn is "next" pointer
        while (nn != null){
            if (curr.val == nn.val){
                curr.next = nn.next;
            } else{
                curr = curr.next;
            }
            nn = curr.next;
        }
        return head;
    }
}
