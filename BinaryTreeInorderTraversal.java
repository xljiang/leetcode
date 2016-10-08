package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import dataStructure.TreeNode;

public class BinaryTreeInorderTraversal {

	
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        inorderRec(root, result);
        return result;
    }
    
    private void inorderRec(TreeNode node, List<Integer> result){
        if (node == null) return;
        if (node.left != null){
            inorderRec(node.left, result);
        }
        
        result.add(node.val);
        
        if (node.right != null){
            inorderRec(node.right, result);
        }
    }
    
    // method 2: iterative + stack
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
    
}
