package leetcode;

import java.util.Stack;

import dataStructure.TreeNode;

public class InOrderSuccessorInBST {
	
	//method 1: iterative in-order traversal: O(n) time, O(logn) space
	// didn't use BST properties
	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p){
		Stack<TreeNode> stack = new Stack<>();
		
		TreeNode prev = null;
		while (root != null || !stack.isEmpty()){
			while (root != null){
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
//			System.out.println("root:" + root.val);
//			if (prev != null ) System.out.println("prev: " + prev.val);
			if (prev != null && prev.val == p.val){
				return root;
			}
			prev = root;
			root = root.right;
		}
		return null;
	}
	
	
	// method 2: use BST properties, O(h) time, O(1) space
	public static TreeNode inorderSuccessor2(TreeNode root, TreeNode p){
		TreeNode succ = null;
		while (root != null){
			if (p.val < root.val){
				succ = root;
				root = root.left;
			} else {
				root = root.right;
			}
		}
		
		return succ;
	}
	
	// test code
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] array2 = {4,8,10,12,14,20,22,28};
		ConvertSortedArrayToBinarySearchTree convertBST = new ConvertSortedArrayToBinarySearchTree();
		TreeNode root = convertBST.sortedArrayToBST(array2);
		TreeNode p = find(root, 8);
		TreeNode successor = inorderSuccessor2(root, p);
		if (successor != null){
			System.out.println("successor is: " + successor.val);
		} else {
			System.out.println("successor is null");
		}
	}
	
	public static TreeNode find(TreeNode root, int num) {
		if (num == root.val) {
			return root;
		} else if (num <= root.val) {
			return root.left != null ? find(root.left, num) : null;
		} else if (num > root.val) {
			return root.right != null ? find(root.right, num) : null;
		}
		return null;
	}
}
