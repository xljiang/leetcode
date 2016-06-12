package leetcode;

import java.util.HashMap;

public class ClimbingStairs {

	HashMap<Integer, Integer> ways = new HashMap<>();
	
	public int climbStairs(int n){
		if (n <= 0) return 0;
		if (n == 1 || n == 2) return n;
		
		if (ways.containsKey(n)){
			return ways.get(n);
		} else {
			int value = climbStairs(n - 1) + climbStairs(n - 2);
			ways.put(n, value);
			return ways.get(n);
		}
	}
	
	// method 2
	
	public int climbStairs2(int n){
		if (n <= 1) return 1;
		int last = 1, lastlast = 1;
		int now = 0;
		for (int i = 2; i <= n; i++){
			now = last + lastlast;
			lastlast = last;
			last = now;
		}
		return now;
	}
}
