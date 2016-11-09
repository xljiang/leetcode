package leetcode;

import java.util.Stack;

import dataStructure.TreeNode;

public class KthSmallestElementInABST {
	
	// method 1: iterative in-order traversal
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) break;
            root = root.right;
        }
        return root.val;
    }
}
