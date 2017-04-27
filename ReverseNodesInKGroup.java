package leetcode;

import dataStructure.ListNode;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev = newHead;
        ListNode curr = head;

        int len = 0;
        while (curr != null){
            curr = curr.next;
            len++;
        }
        if (k == 0) return head;
        int m = len / k;

        curr = head; // put curr back to head
        for (int j = 1; j <= m; j++){
            for (int i = 1; i <= k - 1; i++){
                ListNode nxt = curr.next;
                curr.next = nxt.next;
                nxt.next = prev.next;
                prev.next = nxt;

            }
            prev = curr;
            curr = prev.next;
        }
        
        return newHead.next;
    }
}
