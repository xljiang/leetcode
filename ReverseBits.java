package leetcode;

public class ReverseBits {

	// n is a unsigned value
	public int reverseBits(int n){
		int res = 0;
		for (int i = 31; i >=0; i--){
			int bit = n & 1;
			n >>= 1;
			res += bit << i;
		}
		return res;
	}
}
