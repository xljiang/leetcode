package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public List<List<Integer>> fourSum(int[] nums, int target){
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < nums.length - 3; i++){
			if (i > 0 && nums[i] == nums[i-1]) continue; // avoid duplicates
			for (int j = i + 1; j < nums.length - 2; j++){
				if (j > (i+1) && nums[j] == nums[j-1]) continue; // avoid duplicates
				int k = j + 1, l = nums.length - 1;
				while (k < l){
					if ((nums[i] + nums[j] + nums[k] + nums[l]) == target){
						result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
						k++;
						l--;
						while(k < l && nums[k] == nums[k-1]) k++; // avoid duplicates
						while(k < l && nums[l] == nums[l+1]) l--; // avoid duplicates
					} else if ((nums[i] + nums[j] + nums[k] + nums[l]) < target){
						k++;
					} else {
						l--;
					}
				}
			}
		}
		return result;
	}
}
