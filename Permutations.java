package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public List<List<Integer>> permute (int[] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if (nums == null || nums.length == 0){
			return result;
		}
		
		List<Integer> path = new ArrayList<Integer>();
		permuteRec(result, path, nums);
		return result;
	}
	
	private void permuteRec(List<List<Integer>> result, List<Integer> path, int[] nums){
		if (path.size() == nums.length){
			result.add(new ArrayList<Integer>(path)); // hard copy
			return;
		}
		
		for (int i = 0; i < nums.length; i++){
			if (path.contains(nums[i])){ // element already exists/used, skip
				continue;
			}
			path.add(nums[i]);
			permuteRec(result, path, nums);
			path.remove(path.size() - 1);  // reset
		}
	}
}
