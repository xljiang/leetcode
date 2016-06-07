package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import dataStructure.TreeNode;

public class BinaryTreePreorderTraversal {
	
	// method 1: recursive
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preorderRec(root, result);
        return result;
    }
    
    private void preorderRec(TreeNode node, List<Integer> result){
        if (node == null) return;
        result.add(node.val);
        if (node.left != null) preorderRec(node.left, result);
        if (node.right != null) preorderRec(node.right, result);
    }
    
    // method 2: iterative + stack
    public List<Integer> preorderTraversal2(TreeNode root){
    	List<Integer> result = new ArrayList<Integer>();
    	if (root == null) return result;
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	stack.push(root);
    	
    	while (!stack.isEmpty()){
    		TreeNode n = stack.pop();
    		result.add(n.val);
    		if (n.right != null) stack.push(n.right);
    		if (n.left != null) stack.push(n.left);
    	}
    	
    	return result;
    }
}
