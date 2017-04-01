package leetcode;

public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int len = 1;
        int dupl = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[i-1]){
                nums[len++] = nums[i];
                dupl = 1;
            } else if (dupl == 1){
                nums[len++] = nums[i];
                dupl = 2;
            }
        }
        return len;
    }
    
    // method 2
    public int removeDuplicates2(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index-2]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
