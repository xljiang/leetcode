package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

	
	public List<List<Integer>> permuteUnique(int[] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0){
			return result;
		}
		
		Arrays.sort(nums);
		
		boolean[] isUsed = new boolean[nums.length]; // indicate whether the value is added to list
		List<Integer> path = new ArrayList<Integer>();
		recHelper(result, path, nums, isUsed);
		return result;
	}
	
	private void recHelper(List<List<Integer>> result, List<Integer> path, int[] nums, boolean[] isUsed){
		if (path.size() == nums.length){
			result.add(new ArrayList<Integer>(path));
			return;
		}
		
		for (int i = 0; i < nums.length; i++){
			if (isUsed[i]){ // element already exists/used, skip
				continue;
			}
			
			// when a number has the same value with its previous, we can use this number only if his previous is used
			if (i > 0 && nums[i] == nums[i-1] && !isUsed[i-1]){ // duplicate element, if his previous is not used, skip
				continue;
			}
			path.add(nums[i]);
			isUsed[i] = true;
			recHelper(result, path, nums, isUsed);
			path.remove(path.size() - 1);
			isUsed[i] = false;
		}
	}
}
