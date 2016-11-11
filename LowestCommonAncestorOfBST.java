package leetcode;

import dataStructure.TreeNode;

public class LowestCommonAncestorOfBST {
	
	// method 1: recursive
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if ((p.val <= root.val && q.val >= root.val) || (p.val >= root.val && q.val <= root.val)){
			return root;
		} 
		if (p.val < root.val && q.val < root.val){
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return lowestCommonAncestor(root.right, p, q);
		}
	}
	
	// method 2: iterative
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (true){
            if (p.val < root.val && q.val < root.val){
                root = root.left;
            } else if (p.val > root.val && q.val > root.val){
                root = root.right;
            } else {
                return root;
            }
        }
    }
}
