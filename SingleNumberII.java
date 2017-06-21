package leetcode;

public class SingleNumberII {

	// tricky bit manipulation!!
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int i = 0; i < nums.length; i++){
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
    
    // method 2, much easier and more general
    public int singleNumber2(int[] nums){
    	
    	// put nums[j] in 32 bit, count number of 1 in every bit[i]
    	int[] bits = new int[32];
    	for (int i = 0; i < 32; i++){
    		for (int j = 0; j < nums.length; j++){
    			bits[i] += (nums[j] >> i) & 1;
    		}
    	}
    	
    	// get mod for each bit[i], that is the result;
    	int result = 0;
    	for (int i = 0; i < 32; i++){
    		result += (bits[i] % 3) << i;
    	}
    	return result;
    }
    
    // method 2 improvement 1: one pass
    public int singleNumber3(int[] nums) {
        int result=0;
        int[] bits=new int[32];
        for (int i = 0; i < 32; i++) {
            for(int j = 0; j < nums.length; j++) {
                bits[i] += ((nums[j] >> i) & 1);
                bits[i] %= 3;
            }
            result |= (bits[i] << i);
        }
        return result;
    }

	// method 3 improvement 2: one pass + no extra bits array
    
	
}
