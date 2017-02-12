package leetcode;

public class HouseRobber {
	
	// a typical weighted independent set problem
	public int rob(int[] nums){
        int n = nums.length;
        if (n == 0) return 0;
        
        int[] money = new int[n + 1];
        money[0] = 0;
        money[1] = nums[0];
        for (int i = 2; i < n+1; i++){
            money[i] = Math.max(money[i-1], money[i-2] + nums[i-1]);
        }
        
        return money[n];
	}
	
	// space optimized solution
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int lastLast = 0;
        int last = nums[0];
        int curr = last;
        for (int i = 2; i <= nums.length; i++) {
            curr = Math.max(last, lastLast + nums[i-1]);
            lastLast = last;
            last = curr;
        }
        return curr;
    }
}
