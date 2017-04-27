package leetcode;

public class NextPermutation {

	public void nextPermutation(int[] nums) {

		// Step 1: find partitionIndex (partitionNum: the first digit violate the increase trend)
		int partitionIndex = -1;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				partitionIndex = i - 1;
				break;
			}
		}

		if (partitionIndex == -1) {
			reverse(nums, 0, nums.length - 1);
			return;
		}
		
		// Step 2: find changeIndex (changeNum: the first digit larger than the partitionNum)
		int changeIndex = partitionIndex + 1;
		for (int i = nums.length - 1; i > partitionIndex; i--) {
			if (nums[i] > nums[partitionIndex]) {
				changeIndex = i;
				break;
			}
		}

		// Step 3: swap the partitionNum and changeNum
		swap(nums, partitionIndex, changeIndex);

		// Step 4: reverse all the digit on the right of partitionIndex
		reverse(nums, partitionIndex + 1, nums.length - 1);
	}

	private void reverse(int[] nums, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			swap(nums, i, j);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
