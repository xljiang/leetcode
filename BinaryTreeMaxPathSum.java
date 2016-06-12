package leetcode;

import dataStructure.TreeNode;

public class BinaryTreeMaxPathSum {

	// time O(n), space O(logn)
	private int maxSum;
	
	public int maxPathSum(TreeNode root){
		maxSum = Integer.MIN_VALUE;
		dfs(root);
		return maxSum;
	}
	
	private int dfs(TreeNode root){
		if (root == null) return 0;
		int l = dfs(root.left);
		int r = dfs(root.right);
		if (l < 0) l = 0;
		if (r < 0) r = 0;
		maxSum = Math.max(maxSum, root.val + l + r);
		return root.val + Math.max(l, r);
	}
}
