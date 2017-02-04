package leetcode;

import java.util.HashMap;

public class ClimbingStairs {
	// memoization + recursion
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
	
	// dp
	public int climbStairs3(int n){
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] cache = new int[n+1];
        cache[1] = 1;
        cache[2] = 2;
        for (int i = 3; i <= n; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
	}
	
	// dp with optimized space
	public int climbStairs2(int n){
        if (n == 1) return 1;
        if (n == 2) return 2;
        int last = 1; // n = 1
        int lastlast = 2; // n = 2
        int now = 0;
        for (int i = 3; i <= n; i++) {
            now = last + lastlast;
            last = lastlast;
            lastlast = now;
        }
        return now;
	}
	
	

}
