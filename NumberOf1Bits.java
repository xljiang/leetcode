package leetcode;

public class NumberOf1Bits {

    // you need to treat n as an unsigned value
	
	// method 1: check bit
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            if ( (n & 1) != 0){
                count++;
            }
            n >>>= 1;
        }
        return count;
    }
    
    // method 2: use n&(n-1)
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
