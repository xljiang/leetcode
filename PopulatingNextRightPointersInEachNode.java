package leetcode;

import dataStructure.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode {

	// recursive
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        root.next = null;
        connectRec(root);
    }

    private void connectRec(TreeLinkNode node){
        if (node == null) return;
        
        if (node.left == null && node.right == null) return;
        
        node.left.next = node.right;
        if (node.next == null){
            node.right.next = null;
        } else {
            node.right.next = node.next.left;
        }
        
        connectRec(node.left);
        connectRec(node.right);
    }
    
    // iterative
    public void connect2(TreeLinkNode root){
        if (root == null) return;
        root.next = null;
    	TreeLinkNode node = root;
    	
    	while (node != null && node.left != null){

    		TreeLinkNode p = node;
    		
    		// traverse one level
    		while (p != null){
    			p.left.next = p.right;
    			if (p.next != null){
    			    p.right.next = p.next.left;
    			} else {
    			    p.right.next = null;
    			}
    			p = p.next;
    		} 
    		
    		node = node.left;
    	}
    }
}
