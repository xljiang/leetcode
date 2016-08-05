package leetcode;

public class PowerOfFour {

    public boolean isPowerOfFour(int num) {
    	return (num > 0) 
    			&& ((num & (num - 1)) == 0) 
    			&& ((num & 0x55555555) == num); // check if 1 is located at the odd position
    }
}
