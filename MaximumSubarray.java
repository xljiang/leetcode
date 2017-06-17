package leetcode;

public class MaximumSubarray {
	// dp
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] f = new int[n+1]; // f[i] is the max sum of subarray ending with i
        f[0] = 0;
        int sum = Integer.MIN_VALUE; 
        for (int i = 1; i <= n; i++){
        	// case 1: subarray[0, i-1] > 0, has contribution ==> f[i] = f[i-1] + value of the ith number
        	// case 2: subarray[0, i-1] <= 0, no contribution ==> f[i] = value of ith number
            f[i] = Math.max(f[i-1] + nums[i-1], nums[i-1]); 
            sum = Math.max(f[i], sum); // sum is the maximum of f[i], 1 <= i <= n
        }
        
        return sum;
    }
    
    // dp, more concise version, O(1) space
    public int maxSubArray2(int[] nums){
    	int n = nums.length;
    	int f = 0;
    	int sum = Integer.MIN_VALUE;
    	for (int i = 1; i <= n; i++){
    		f = Math.max(f + nums[i-1], nums[i-1]);
    		sum = Math.max(f, sum);
    	}
    	return sum;
    }
    
    // greedy
    public int maxSubArray3(int[] nums){
    	int sum = 0, min = 0, res = nums[0];
    	for (int i = 0; i < nums.length; i++){
    		sum += nums[i];
    		if (sum - min > res) res = sum - min;
    		if (sum < min) min = sum;
    	}
    	return res;
    }
    
    // a simple solution (actually same as dp above)
    public int maxSubArray4(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
