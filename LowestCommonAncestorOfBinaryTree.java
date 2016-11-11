package leetcode;

import dataStructure.TreeNode;

public class LowestCommonAncestorOfBinaryTree {
	
	// method 1: worst case O(n)
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == p || root == q){
            return root;
        }
        
        // Divide
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // Conquer
        if (left == null){
            return right;
        } else if (right == null){
            return left;
        } else { // left != null && right != null
            return root;
        }
	}
	
	// method 2: calculate total matches in the left subtree, worst case O(n2)
	public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
		if (root == null || p == null || q == null){
			return null;
		}
		if (p == root || q == root) return root;
		int totalMatches = totalMatches(root.left, p, q); // find total matches in the left subtree
		if (totalMatches == 1){
			return root;
		} else if (totalMatches == 2){
			return lowestCommonAncestor2(root.left, p, q);
		} else {// totalMatches == 0
			return lowestCommonAncestor2(root.right, p, q);
		}
	}

	private static int totalMatches(TreeNode root, TreeNode p, TreeNode q){
		int totalMatches = 0;
		if (nodeInTree(root, p)){
			totalMatches++;
		}
		if (nodeInTree(root, q)){
			totalMatches++;
		}
		return totalMatches;
	}
	
	private static boolean nodeInTree(TreeNode root, TreeNode p){
	    if (root == null) return false;
		if (root == p) return true;
		return nodeInTree(root.left, p) || nodeInTree(root.right, p);
	}
	
	// with links to parents
	// see cc189 4.8
}
