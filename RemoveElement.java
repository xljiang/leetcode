package leetcode;

public class RemoveElement {

	// method 1: when val is found in nums[], let nums[i] be the last element in the modifying array
	// then repeat searching until val is not found.
	public int removeElement(int[] nums, int val){
		if (nums == null || nums.length == 0){
			return 0;
		}
		int length = nums.length;
		for (int i = 0; i < length; i++){
			while (nums[i] == val && i < length){
				nums[i] = nums[length - 1];
				length--;
			}
		}
		return length;
	}
	
	// method 2: two pointers, new array
    public int removeElement2(int[] nums, int val) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int length = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                nums[length] = nums[i];
                length++;
            }
        }
        return length;
    }
}
