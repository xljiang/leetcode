package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

	public List<List<Integer>> combinationSum3(int k, int n){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		recHelper(result, path, k, n, 1);
		return result;
	}
	
	private void recHelper(List<List<Integer>> result, List<Integer> path, int k, int n, int start){
		if (n < 0){
			return;
		}
		
		if (n == 0 && path.size() == k){
			result.add(new ArrayList<Integer>(path));
			return;
		}
		
		for (int i = start; i <= 9; i++){
			path.add(i);
			recHelper(result, path, k, n - i, i+1);
			path.remove(path.size() - 1);
		}
	}
	
	// another helper I wrote, pretty much similar as above
    private void helper(List<List<Integer>> result, List<Integer> path, int k, int target, int start) {
        if (target < 0) return;
        if (k < 0) return;
        if (target == 0 && k == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = start; i <= 9; i++) {
            path.add(i);
            helper(result, path, k-1, target-i, i+1);
            path.remove(path.size() - 1);
        }
    }
}
