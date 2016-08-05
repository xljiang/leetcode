package leetcode;

import dataStructure.ListNode;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev = newHead;
        for (int i = 1; i < m; i++){
            prev = prev.next;
        }

        ListNode curr = prev.next;
        for (int i = 1; i <= n - m; i++){
            ListNode nn = curr.next;
            curr.next = nn.next;
            nn.next = prev.next;
            prev.next = nn;
        }
        
        return newHead.next;
    }
}
