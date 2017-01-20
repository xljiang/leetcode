package leetcode;


import java.util.HashMap;

import dataStructure.TreeNode;

public class PathSumIII {

	// method 1: brute force
	// O(nlogn) time for balanced tree, O(n^2) time for worst case
	public int pathSum(TreeNode root, int sum){
		if (root == null){
			return 0;
		}
		return pathSumFromNode(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}
	
	private int pathSumFromNode(TreeNode root, int sum){
		int totalPaths = 0;
		if (root == null){
			return totalPaths;
		}
		
		if (sum == root.val){
			totalPaths++;
		}
		
		totalPaths += pathSumFromNode(root.left, sum - root.val);
		totalPaths += pathSumFromNode(root.right, sum - root.val);
		
		return totalPaths;
	}
	
	
	// method 2: hash table
	// time O(n). space: balanced tree O(logn), unbalanced O(n)
	public int pathSum2(TreeNode root, int sum){
		HashMap<Integer, Integer> map = new HashMap<>();
		return backtrack(root, sum, 0, map);
	}
	
	private int backtrack(TreeNode root, int target, int runningSum, HashMap<Integer, Integer> map){
		if (root == null) return 0; // base case
		
		// count paths with target ending at the current node
		runningSum += root.val;
		int totalPaths = map.getOrDefault(runningSum - target, 0); // see if there is a subarray sum equals to target
		
		// if runningSum == target, then one additional path starts at root.
		// add in this path
		if (runningSum == target){
			totalPaths++;
		}
		
		// increment map
		incrementHashTable(map, runningSum, 1); 
		
		// recurse, extend to left and right child
		totalPaths += backtrack(root.left, target, runningSum, map);
		totalPaths += backtrack(root.right, target, runningSum, map);
		
		// decrement map (backtrack)
		incrementHashTable(map, runningSum, -1);
		
		return totalPaths;
	}
	
	private void incrementHashTable(HashMap<Integer, Integer> map, int runningSum, int n){
		int newCount = map.getOrDefault(runningSum, 0) + n;
		if (newCount == 0){
			map.remove(runningSum); // remove when zero to reduce space usage
		} else {
			map.put(runningSum, newCount);
		}
	}
	
	// a simplified version of method 2
	public int pathSum3(TreeNode root, int sum){
		HashMap<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1); // why??? default sum = 0 has one count
		return helper(root, sum, 0, preSum);
	}
	
	private int helper(TreeNode root, int target, int runningSum, HashMap<Integer, Integer> preSum){
		if (root == null) return 0;
		
		runningSum += root.val;
		int totalPaths = preSum.getOrDefault(runningSum - target, 0);
		preSum.put(runningSum, preSum.getOrDefault(runningSum, 0) + 1);
		
		totalPaths += helper(root.left, target, runningSum, preSum) + helper(root.right, target, runningSum, preSum);
		preSum.put(runningSum, preSum.get(runningSum) - 1);
		
		return totalPaths;
	}
}
