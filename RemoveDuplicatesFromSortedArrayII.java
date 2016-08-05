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
}
