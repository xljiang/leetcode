package leetcode;

public class SearchForARange {

    public int[] searchRange(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int[] result = {-1, -1};
        
        // search for left boundary
        while (i < j){
            int mid = i + (j-i)/2; // mid biased to the left
            if (nums[mid] < target){
                i = mid + 1;
            } else if (nums[mid] > target){
                j = mid - 1;
            } else {
                j = mid;
            }
        }
        
        if (nums[i] != target){
            return result;
        } else {
            result[0] = i;
        }
        
        // search for right boundary
        j = nums.length - 1; // reset j
        while (i < j){
            int mid = j - (j-i)/2; // mid biased to the right
            if (nums[mid] < target){
                i = mid + 1;
            } else if (nums[mid] > target){
                j = mid - 1;
            } else {
                i = mid;
            }
        }
        result[1] = j;
        return result;
    }
    
    // simplified
    public int[] searchRange2(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int[] result = {-1, -1};
        
        // search for left boundary
        while (i < j){
            int mid = i + (j-i)/2; // mid biased to the left
            if (nums[mid] < target){
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        
        if (nums[i] != target){
            return result;
        } else {
            result[0] = i;
        }
        
        // search for right boundary
        j = nums.length - 1; // reset j
        while (i < j){
            int mid = j - (j-i)/2; // mid biased to the right
            if (nums[mid] > target){
                j = mid - 1;
            } else {
                i = mid;
            }
        }
        result[1] = j;
        return result;
    }
}
