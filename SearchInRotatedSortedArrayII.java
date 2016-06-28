package leetcode;

public class SearchInRotatedSortedArrayII {

	public boolean search(int[] nums, int target){
		int i = 0, j = nums.length - 1;
		while ( i <= j){
			int mid = i + (j-i)/2;
			if (nums[mid] == target){
				return true;
			}
			if (nums[mid] > nums[i]){
				if (nums[mid] > target && nums[i] <= target){ // nums[i]<=target<nums[mid]
					j = mid - 1;
				} else {
					i = mid + 1;
				}
			} else if (nums[mid] < nums[j]){
				if (nums[mid] < target && nums[j] >= target){ // nums[mid]<target<=nums[j]
					i = mid + 1;
				} else{
					j = mid - 1;
				}
			} else {
				j--;
			}
		}
		return false;
	}
}
