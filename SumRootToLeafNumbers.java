package leetcode;

import dataStructure.TreeNode;

public class SumRootToLeafNumbers {

	int sum = 0;
	
	public int sumNumbers(TreeNode root){
		if (root == null) return 0;
		sumPath(root, 0);
		return sum;
	}
	
	private void sumPath(TreeNode root, int sumPath){
		if (root == null) return;
		
		sumPath += sumPath * 10 + root.val;
		
		if (root.left == null && root.right == null){
			sum += sumPath;
		} else {
			sumPath(root.left, sumPath);
			sumPath(root.right, sumPath);
		}
	}
	
	// a concise version
	
	public int sumNumbers2(TreeNode root){
		return sumPath2(root, 0);
	}
	
	private int sumPath2(TreeNode root, int sum){
		if (root == null) return 0;
		
		sum = sum * 10 + root.val;
		
		if (root.left == null && root.right == null){
			return sum;
		} else {
			return sumPath2(root.left, sum) + sumPath2(root.right, sum);
		}
	}
	
}
