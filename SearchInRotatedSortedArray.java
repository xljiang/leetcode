package leetcode;

public class SearchInRotatedSortedArray {

	// method 1:
	public int search(int[] nums, int target){
		return searchRec(nums, target, 0, nums.length - 1);
	}
	
	public int searchRec(int[] nums, int target, int left, int right){
		if (nums[right] >= nums[left]){
			int i = left, j = right;
			while ( i <= j){
				int mid = i + (j-i)/2;
				if (nums[mid] == target){
					return mid;
				} else if (nums[mid] > target){
					j = mid - 1;
				} else{
					i = mid + 1;
				}
			}
		} else {
			int mid = left + (right - left)/2;
			int res1 = searchRec(nums, target, left, mid);
			int res2 = searchRec(nums, target, mid+1, right);
			return res1 != -1 ? res1 : res2;
		}
		return -1;
	}
	
	// method 2:
	public int search2(int[] nums, int target){
		int i = 0, j = nums.length - 1;
		while ( i <= j){
			int mid = i + (j-i)/2;
			if (nums[mid] == target){
				return mid;
			}
			if (nums[i] <= nums[mid]){
				if (nums[mid] > target && nums[i] <= target){ // nums[i]<=target<nums[mid]
					j = mid - 1;
				} else {
					i = mid + 1;
				}
			} else { 
				if (nums[mid] < target && nums[j] >= target){ // nums[mid]<target<=nums[j]
					i = mid + 1;
				} else{
					j = mid - 1;
				}
			}
		}
		return -1;
	}
}
