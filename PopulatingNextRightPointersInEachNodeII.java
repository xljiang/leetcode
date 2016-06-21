package leetcode;

import java.util.LinkedList;
import java.util.Queue;

import dataStructure.TreeLinkNode;

public class PopulatingNextRightPointersInEachNodeII {

	// method 1: not constant space!
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.add(root);
        
        while (!q.isEmpty()){
            int size = q.size();
            TreeLinkNode prev = q.peek();
            TreeLinkNode curr = null;
            while (size > 0){
                curr = q.poll();
                if (prev != curr) prev.next = curr;
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
                prev = curr;
                size--;
            }
            curr.next = null;
        }
    }
    
    // method 2: O(1) space, O(n) complexity
    public void connect2(TreeLinkNode root) {
        TreeLinkNode head = root; // the left most node in the lower level
        TreeLinkNode prev = null; // the previous node in the lower level
        TreeLinkNode curr = null; // the current node in the upper level
        
        while (head != null){
            curr = head;
            prev = null;
            head = null;
            
            while (curr != null){
                if (curr.left != null){
                    if (prev != null)
                        prev.next = curr.left;
                    else 
                        head = curr.left;
                    prev = curr.left;
                }
                if (curr.right != null){
                    if (prev != null)
                        prev.next = curr.right;
                    else 
                        head = curr.right;
                    prev = curr.right;
                }
                curr = curr.next;
            }
        }
    }
}
