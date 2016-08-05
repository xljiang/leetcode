package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dataStructure.TreeNode;

public class BinaryTreeLevelOrderTraversalII {

	public List<List<Integer>> levelOrderBottom(TreeNode root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) return result;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()){
			int size = q.size();
			List<Integer> oneLevel = new ArrayList<>();
			
			while (size > 0){
				TreeNode n = q.poll();
				oneLevel.add(n.val);
				if (n.left != null) q.add(n.left);
				if (n.right != null) q.add(n.right);
				size--;
			}
			result.add(0, oneLevel); // add in front of the list
		}
		
		return result;
	}
}
