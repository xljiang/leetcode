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

        Stack<TreeNode> st = new Stack<TreeNode>();

        TreeNode curr = root;
        while (curr != null || !st.isEmpty()){
            
            while(curr != null){
                st.add(curr);
                curr = curr.left;
            }
            curr = st.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
    
}
