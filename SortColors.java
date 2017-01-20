package leetcode;

public class SortColors {

	// method 1: two-pass algorithm, counting sort
    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] == 0) red++;
            if (nums[i] == 1) white++;
            if (nums[i] == 2) blue++;
        }
        for (int i = 0; i < red; i++){
            nums[i] = 0;
        }
        for (int i = red; i < (red + white); i++){
            nums[i] = 1;
        }
        for (int i = (red + white); i < nums.length; i++){
            nums[i] = 2;
        }
    }
    
    // method 2: one-pass algorithm
    // use two pointer zero and two, and an iterator i; sweep all 0s to the left and all 2s to the right,
    // then all 1s are left in the middle
    public void sortColors2(int[] nums) {
        int zero = 0, two = nums.length - 1;
        for (int i = 0; i <= two;) {
            if (nums[i] == 0) {
                swap(nums, i, zero);
                zero++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, two);
                two--;
            } else {
                i++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
}
