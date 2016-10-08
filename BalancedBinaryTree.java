package leetcode;

import dataStructure.TreeNode;

public class BalancedBinaryTree {
	
	// method 1, top-down, O(nlogn) time
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int heightDiff = Math.abs(maxDepth(root.left) - maxDepth(root.right));
        if (heightDiff > 1){
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }
    
    private int maxDepth(TreeNode root){
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    
    
    // method 2, bottom-up, O(n) time, O(logn) space
    public boolean isBalanced2(TreeNode root) {
        if (root == null) return true;
        return getHeight(root) != -1;
    }
    
    private int getHeight(TreeNode root){
        if (root == null) return 0;

        int left = getHeight(root.left);
        if (left == -1) return -1;

        int right = getHeight(root.right);
        if (right == -1) return -1;

        if (Math.abs(left-right) > 1){
            return -1;
        }
        
        return Math.max(left, right) + 1;
    }
}
