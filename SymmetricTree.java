package leetcode;

import java.util.LinkedList;
import java.util.Queue;

import dataStructure.TreeNode;

public class SymmetricTree {

	// method 1, recursive
	public boolean isSymmetric(TreeNode root){
		if (root == null) return true;
		return isSymmetric(root.left, root.right);
	}
	
	public boolean isSymmetric(TreeNode p, TreeNode q){
		if (p == null && q == null){
			return true;
		}
		if (p != null && q != null && p.val == q.val){
			return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
		} else {
			return false;
		}
	}
	
	// method 2, iterative: use queue and BFS (or use stack and DFS)
	public boolean isSymmetric2(TreeNode root){
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(root);
		while (!q.isEmpty()){
			TreeNode n1 = q.poll();
			TreeNode n2 = q.poll();
			if (n1 == null && n2 == null) continue;
			if (n1 == null || n2 == null) return false;
			if (n1.val != n2.val) return false;
			q.add(n1.left);
			q.add(n2.right);
			q.add(n1.right);
			q.add(n2.left);
		}
		return true;
	}
}
