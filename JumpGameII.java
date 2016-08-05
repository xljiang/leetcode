package leetcode;

public class JumpGameII {

	// Greedy
	public int jump(int[] nums){
        if (nums == null || nums.length == 0){
            return -1;
        }
        int start = 0, end = 0, jumps = 0; //[start, end] current covered range
        while (end < nums.length - 1){ // jump as far as you can?
            jumps++;
            int farthest = end;
            for (int i = start; i <= end; i++){
                farthest = Math.max(farthest, nums[i] + i);
            }
            start = end + 1;
            end = farthest;
        }
        
        return jumps;
	}
}
