package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dataStructure.TreeNode;

public class BinaryTreeLevelOrderTraversal {

	// method 1: recursive, O(n) time, O(n) space
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        levelOrderRec(result, root, 0);
        return result;
    }
    
    private void levelOrderRec(List<List<Integer>> result, TreeNode root, int level){
        if (root == null) return;
        if (level == result.size()){
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        levelOrderRec(result, root.left, level + 1);
        levelOrderRec(result, root.right, level + 1);
    }
	
	// method 2: iterative, O(n) time, O(n) space
	public List<List<Integer>> levelOrder2(TreeNode root){
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
			result.add(oneLevel);
		}
		
		return result;
	}
}
