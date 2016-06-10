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
		int sum = root.val;
		if (l > 0) sum += l;
		if (r > 0) sum += r;
		maxSum = Math.max(maxSum, sum);
		return Math.max(l, r) > 0 ? Math.max(l, r) + root.val : root.val;
	}
}
