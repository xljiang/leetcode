package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import dataStructure.TreeNode;

public class BinaryTreePostorderTraversal {

	// method 1: recursive
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        postorderRec(root, result);
        return result;
    }
    
    private void postorderRec(TreeNode node, List<Integer> result){
        if (node == null) return;
        if (node.left != null) postorderRec(node.left, result);
        if (node.right != null) postorderRec(node.right, result);
        result.add(node.val);
    }
    
    // method 2: 
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        TreeNode lastpop = root;
        
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node.left != null && node.left != lastpop && node.right != lastpop){
                stack.push(node.left);
            } else if (node.right != null && (node.left == null || node.left == lastpop) && node.right != lastpop) {
                stack.push(node.right);
            } else {
                lastpop = stack.pop();
                result.add(lastpop.val);
            }
        }
        
        return result;
    }
    
    // more iterative
    
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        TreeNode prev = null;

        while(!stack.isEmpty()){
            TreeNode curr = stack.peek(); 
            if (prev == null || prev.left == curr || prev.right == curr){ // traverse down
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) {  // from left to right
                if (curr.right != null){
                    stack.push(curr.right);
                }
            } else { // from right up
                result.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }
        
        return result;
    }
}
