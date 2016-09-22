package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	public List<List<Integer>> threeSum(int[] nums){
	    Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		for(int i = 0; i < nums.length - 2; i++){
			if (i > 0 && nums[i] == nums[i-1]) continue; // avoid duplicates
			int target = 0 - nums[i];
			int lo = i + 1, hi = nums.length - 1;
			while (lo < hi){
				if ((nums[lo] + nums[hi]) == target){
					result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
					lo++;
					hi--;
					while(lo < hi && nums[lo] == nums[lo-1]) lo++; // avoid duplicates
					while(lo < hi && nums[hi] == nums[hi+1]) hi--; // avoid duplicates
				} else if ((nums[lo] + nums[hi]) < target){
						lo++;
				} else {
						hi--;
				}
			}
		}
		return result;
	}
}
