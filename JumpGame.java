package leetcode;


public class JumpGame {
	
	// Greedy: O(n) time, O(1) space
    public boolean canJump(int[] nums){
    	if (nums == null || nums.length == 0){
    		return false;
    	}
    	
    	int farthest = nums[0];
    	for (int i = 1; i <= farthest && farthest < nums.length; i++){
    		farthest = Math.max(farthest, i + nums[i]);
    	}
    	return farthest >= nums.length - 1;
    }
    
}



