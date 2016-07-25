package leetcode;

import dataStructure.ListNode;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA, h2 = headB;
        int count1 = 0, count2 = 0;
        while(h1 != null){
            h1 = h1.next;
            count1++;
        }
        while (h2 != null){
            h2 = h2.next;
            count2++;
        }
        if (h1 != h2) return null;
        
        int diff = Math.abs(count1-count2);
        if (count1 > count2){ // h1 move diff steps first
            while(diff > 0){
                headA = headA.next;
                diff--;
            }
        } else if (count1 < count2){ // h2 move diff steps first
            while(diff > 0){
                headB = headB.next;
                diff--;
            }
        }
         
        while (headA != null){ // now A, B leftover has same size
            if (headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    
    // cleaner code, same thought
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    	int lenA = getLength(headA), lenB = getLength(headB);
    	while (lenA > lenB){
    		headA = headA.next;
    		lenA--;
    	}
    	while (lenA < lenB){
    		headB = headB.next;
    		lenB--;
    	}
    	
    	// now A and B leftover has same size
    	// find the intersection until end
    	while (headA != headB){
    		headA = headA.next;
    		headB = headB.next;
    	}
    	return headA;
    }
    
    private int getLength(ListNode head){
    	int len = 0;
    	while (head != null){
    		head = head.next;
    		len++;
    	}
    	return len;
    }
}
