package leetcode;

import java.util.ArrayList;
import java.util.List;

import dataStructure.TreeNode;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        List<Integer> path = new ArrayList<Integer>();
        findPath(root, path, sum, result);
        		
        return result;
    }
    
    private void findPath(TreeNode root, List<Integer> path, int sum, List<List<Integer>> result){
    	if (root == null) return;
    	
    	path.add(root.val);
    	
    	if (root.left == null && root.right == null && root.val == sum){
    		result.add(new ArrayList(path)); // hard copy!
    	} else {
    		findPath(root.left, path, sum - root.val, result);
    		findPath(root.right, path, sum - root.val, result);
    	}
    	path.remove(path.size() - 1);
    }
    

}
