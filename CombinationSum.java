package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0){
			return result;
		}
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
			path.add(candidates[i]);
			recHelper(result, path, candidates, target - candidates[i], i); // not i+1 because we can use same elements
			path.remove(path.size() - 1);
		}
	}
}
