package leetcode;


public class JumpGame {
	
	// Greedy
	public boolean canJump(int[] nums){
		if (nums == null || nums.length == 0){
			return false;
		}
		int farthest = nums[0];
		for (int i = 1; i < nums.length; i++){
			if (i <= farthest && nums[i] + i >= farthest){
				farthest = nums[i] + i;
			}
		}
		return farthest >= nums.length - 1;
	}
	
	// Greedy 2
    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0){
			return false;
		}
	    int farthest = nums[0];
	    for (int i = 0; i <= farthest; i++){
	        farthest = Math.max(farthest, i + nums[i]);
	        if (farthest >= nums.length - 1){
	            return true;
	        }
	    }
	    return false;
    }
    
	// dp
}



