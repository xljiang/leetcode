package leetcode;

import java.util.Stack;

import dataStructure.ListNode;

public class PalindromeLinkedList {

	// method 1: use stack, two pointers
    public boolean isPalindrome2(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        ListNode fast = head, slow = head;
        
        // push first half into the stack
        while (fast != null && fast.next != null){
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (fast != null){ // has odd number, skip middle element
            slow = slow.next;
        }
        
        // compare
        while (slow != null){
            if (stack.pop() != slow.val){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
    
    // method 2: reverse and compare, O(1) space
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, reverse = head, prev = null;
        
        // reverse the first half of the list
        while (fast != null && fast.next != null){
            // reverse
            reverse = slow;
            ListNode tmp = slow.next; // maintain slow.next before reverse
            ListNode tmp2 = fast.next.next; // maintain fast.next.next before reverse
            reverse.next = prev;
            prev = slow;
            
            // move pointers
            slow = tmp;
            fast = tmp2;
        }
        
        // if odd, skip the middle element
        if (fast != null){
            slow = slow.next;
        }
        
        // compare
        while (slow != null){
            if (reverse.val != slow.val){
                return false;
            }
            reverse = reverse.next;
            slow = slow.next;
        }
        return true;
    }
}
