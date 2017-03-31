package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0){
			return result;
		}
		
		List<Integer> path = new ArrayList<Integer>();
		recHelper(result, path, nums, 0);
		return result;
	}
	
	private void recHelper(List<List<Integer>> result, List<Integer> path, int[] nums, int start){
		result.add(new ArrayList<Integer>(path));
		
		for (int i = start; i < nums.length; i++){
			path.add(nums[i]);
			recHelper(result, path, nums, i+1);
			path.remove(path.size() - 1);
		}
	}
	
	// soulmachine solution
	private void recHelper2(List<List<Integer>> result, List<Integer> path, int[] nums, int pos){
		if (pos == nums.length) {
			result.add(new ArrayList<Integer>(path));
			return;
		}
		
		// don't choose nums[pos]
		recHelper2(result, path, nums, pos + 1);
		// choose nums[pos]
		path.add(nums[pos]);
		recHelper2(result, path, nums, pos + 1);
		path.remove(path.size() - 1);

	}
}
