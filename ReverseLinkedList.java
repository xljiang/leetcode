package leetcode;

import dataStructure.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode nn = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nn;
        }
        return prev;
    }
    
    // use dummy head
    public ListNode reverseList2(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode prevHead = dummy.next;
            ListNode next = head.next;
            dummy.next = head;
            head.next = prevHead;
            head = next;
        }
        return dummy.next;
    }
}
