package leetcode;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] fmax = new int[n]; // fmax[i] is the max product of subarray ending with i, 0<=i<n
        int[] fmin = new int[n]; // fmin[i] is the min product of subarray ending with i, 0<=i<n
        fmax[0] = nums[0];
        fmin[0] = nums[0];
        int result = nums[0]; 
        for (int i = 1; i < n; i++){
            fmin[i] = fmax[i] = nums[i];
        	if (nums[i] > 0){
        		fmax[i] = Math.max(fmax[i], fmax[i-1] * nums[i]); 
        		fmin[i] = Math.min(fmin[i], fmin[i-1] * nums[i]);
        	} else if (nums[i] < 0){
        		fmax[i] = Math.max(fmax[i], fmin[i-1] * nums[i]); 
        		fmin[i] = Math.min(fmin[i], fmax[i-1] * nums[i]);
        	} 
            result = Math.max(fmax[i], result);
        }
        
        return result;
    }
}
