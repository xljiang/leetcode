package leetcode;

public class DivideTwoIntegers {
	
	// divide two integers without using *, /, %
	public int divide(int dividend, int divisor){
		if (divisor == 0){
			return Integer.MAX_VALUE;
		}
		if (dividend == Integer.MIN_VALUE && divisor == -1){
			return Integer.MAX_VALUE;
		}
		
		boolean isNegative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
		int ans = 0;
		long dvd = Math.abs((long)dividend);
		long dvs = Math.abs((long)divisor);
		
		while (dvd >= dvs){
			long tmp = dvs;
			int multiple = 1;
			while (dvd >= (tmp << 1)){
				tmp <<= 1;
				multiple <<= 1;
			}
			dvd -= tmp;
			ans += multiple;
		}
		
		return isNegative ? -ans : ans;
	}
}
