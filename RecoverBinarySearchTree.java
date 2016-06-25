package leetcode;

import dataStructure.TreeNode;

public class RecoverBinarySearchTree {

    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    public void inorder(TreeNode root){
        if (root == null) return;
        
        inorder(root.left);
        
        // prev should always have smaller value than curr value
        if (prev != null && prev.val >= root.val){
            
            // incorrect smaller node is always found as prev node
            if (first == null) first = prev;
            
            // incorrect larger node is always found as curr(root) node
            second = root; // no else here! for corner cases, eg. {0, 1}.
        }
        
        prev = root;
        
        inorder(root.right);
    }
}
