package leetcode;

public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        return Math.max(robHelper(nums, 0, n-2), robHelper(nums, 1, n-1));
    }
    
    // rob house from nums[low] to nums[high]
    private int robHelper(int[] nums, int low, int high){
        int n = high - low + 1;
        int[] money = new int[n+1];
        money[0] = 0;
        money[1] = nums[low];
        for (int i = 2; i <= n; i++){
            money[i] = Math.max(money[i-1], money[i-2] + nums[low+i-1]);
        }
        return money[n];
    }
    
    // space optimization
    public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        return Math.max(robHelper2(nums, 0, n-2), robHelper2(nums, 1, n-1));
    }
    
    private int robHelper2(int[] nums, int start, int end) {
        int len = end - start + 1;
        int lastLast = 0;
        int last = nums[start];
        int curr = last;
        for (int i = 2; i <= len; i++) {
            curr = Math.max(last, lastLast + nums[start+i-1]);
            lastLast = last;
            last = curr;
        }
        return curr;
    }
}
