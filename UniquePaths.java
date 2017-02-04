package leetcode;

public class UniquePaths {

	// DFS (TLE for larget data sets): time O(n^2 m^2), space O(n)
	public int uniquePathsDFS(int m, int n){
		if (m < 1 || n < 1) return 0;
		if (m == 1 && n == 1) return 1;
		return uniquePathsDFS(m-1, n) + uniquePathsDFS(m, n-1);
	}
	
	
	// Memoization: time O(nm), space O(nm)
	private int[][] cache; // cache[x][y] is number of paths from (0,0) to (x,y)
	
	public int uniquePaths(int m, int n){
		cache = new int[m][n];
		cache[0][0] = 1;
		return DFS(m-1, n-1);
	}
	
	private int DFS(int x, int y){
	    if (x < 0 || y < 0) return 0;
		if (x == 0 && y == 0) return cache[0][0];
		if (cache[x][y] > 0){
			return cache[x][y];
		} else {
		    cache[x][y] = DFS(x-1, y) + DFS(x, y-1);
		    return cache[x][y];
		}
	}
	
	// another memoization, cache as a help function's parameter
    public int uniquePathsMemo2(int m, int n) {
        int[][] memo = new int[m+1][n+1];
        return uniquePaths(m, n, memo);
    }
    
    private int uniquePaths(int m, int n, int[][] memo) {
        if (m == 1 || n == 1) return 1;
        if (memo[m][n] == 0) {
            memo[m][n] = uniquePaths(m-1, n, memo) + uniquePaths(m, n-1, memo);
        }
        return memo[m][n];
    }
	
	
	// iterative bottom-up DP: time O(nm), space O(nm)
	public int uniquePathsDP(int m, int n){
	    if (m == 0 || n == 0) return 0;
	    
		int[][] res = new int[m][n];
		
		// initialize
		for (int i = 0; i < m; i++){
		    res[i][0] = 1;
		}
		for (int j = 0; j < n; j++){
		    res[0][j] = 1;
		}
		
		// dp
		for (int i = 1; i < m; i++){
			for (int j = 1; j < n; j++){
				res[i][j] = res[i-1][j] + res[i][j-1];
			}
		}
		return res[m-1][n-1];
	}
	
	
	// iterative bottom-up DP, space optimized: time O(nm), space O(n)
	public int uniquePathsDPOpt(int m, int n){
	    if (m == 0 || n == 0) return 0;
	    
		int[] f = new int[n];
		f[0] = 1; // also default f[n, n>=1] = 0
		// dp
		for (int i = 0; i < m; i++){
			for (int j = 1; j < n; j++){
				f[j] = f[j] + f[j-1];
			}
		}
		return f[n-1];
	}
	
	
	// Math: Choose (m-1) from (m+n-2), space O(1)
    public int uniquePathsMath(int m, int n) {
        long ll = fact(m+n-2)/(fact(m-1)*fact(n-1));
        return (int) ll;
    }
    
    private long fact(int n){
        long fact = 1;
        for(int i = 1; i <= n; i++){
            fact = fact*i;
        }
        return fact;
    }
}
