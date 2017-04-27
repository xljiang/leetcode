package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target){
	    Arrays.sort(nums);
	    int sum = 0;
	    int diff = Integer.MAX_VALUE;

	    for (int i = 0; i < nums.length - 2; i++){
	    	int j = i + 1, k = nums.length - 1;
	    	while (j < k){
	    		int sumTemp = nums[i] + nums[j] + nums[k];
	    		if (sumTemp == target){
	    			return sumTemp;
	    		} else if (sumTemp > target){
	    		    k--;
	    		} else { // sumTemp < target
	    		    j++;
	    		}
	    		int diffTemp = Math.abs(target - sumTemp);
	    		if (diff > diffTemp){
	    		    diff = diffTemp;
	    		    sum = sumTemp;
	    		}
	    	}
	    }
		return sum;
	}

}
