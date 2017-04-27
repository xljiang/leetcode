package leetcode;

public class SingleNumberIII {

	public int[] singleNumber(int[] nums){
		// pass 1:
		// get the xor of the two numbers we need to find
		int xor = 0;
		for (int num : nums){
			xor ^= num;
		}
		// get the last set bit: the rightmost 1.
		int rightmost_setBit = xor & (~(xor - 1));
		
		// pass 2:
		int[] res = {0, 0}; // this array stores the two numbers we will return
		for (int num : nums){
			if ((num & rightmost_setBit) == 0){ // the bit is not set
				res[0] ^= num;
			} else { // the bit is set
				res[1] ^= num;
			}
		}
		
		return res;
	}
}
