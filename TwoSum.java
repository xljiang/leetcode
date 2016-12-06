package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	// method 1: one pass, hashmap, O(n) runtime, O(n) space
	public int[] twoSum(int[] nums, int target){
	
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++){
        	if (map.containsKey(target - nums[i])){
        		result[1] = i;
        		result[0] = map.get(target - nums[i]);
        		return result;
        	}
        	map.put(nums[i], i);
        }
        return result;
	}
	
	// method 2: two pointers and sort
	public int[] twoSum2(int[] nums, int target){
		int[] result = new int[2];
		int[] copy = Arrays.copyOf(nums, nums.length);
		Arrays.sort(nums);
		
		int i = 0, j = nums.length - 1;
		while (i < j){
			if ((nums[i] + nums[j]) == target){
				break;
			}
			else if ((nums[i] + nums[j]) < target){
				i++;
			} else { // nums[i] + nums[j] > target
				j--;
			}
		}

		int r = 0;
		for (int k = 0; k < copy.length; k++){
			if (copy[k] == nums[i] || copy[k] == nums[j]){
				result[r++] = k;
			}
		}
		return result;
	}
}
