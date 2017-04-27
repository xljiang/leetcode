package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	public List<List<Integer>> combinationSum2(int[] candidates, int target){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0){
			return result;
		}
		Arrays.sort(candidates);
		List<Integer> path = new ArrayList<Integer>();
		recHelper(result, path, candidates, target, 0);
		return result;
	}
	
	private void recHelper(List<List<Integer>> result, List<Integer> path, int[] candidates, int target, int start){
		if (target < 0){
			return;
		}
		
		if (target == 0){
			result.add(new ArrayList<Integer>(path));
			return;
		}
		
		for (int i = start; i < candidates.length; i++){
			if (i > start && candidates[i] == candidates[i-1]){ // skip duplicates
				continue;
			}
			path.add(candidates[i]);
			recHelper(result, path, candidates, target - candidates[i], i+1);
			path.remove(path.size() - 1);
		}
	}
}
