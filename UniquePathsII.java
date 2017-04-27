package leetcode;

public class UniquePathsII {
	
	// dp
	public int uniquePathsWithObstaclesDP(int[][] obstacleGrid){
		if (obstacleGrid == null) return 0;
	    int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if (m == 0 || n == 0) return 0;
		int f[][] = new int[m][n];
		
		// initialize
		for (int i = 0; i < m; i++){
			if (obstacleGrid[i][0] != 1){
				f[i][0] = 1;
			} else {
				break;
			}
		}
		for (int j = 0; j < n; j++){
			if (obstacleGrid[0][j] != 1){
				f[0][j] = 1;
			} else {
				break;
			}
		}
		
		// dp
		for (int i = 1; i < m; i++){
			for (int j = 1; j < n; j++){
				if (obstacleGrid[i][j] != 1){
					f[i][j] = f[i-1][j] + f[i][j-1];
				} else {
					f[i][j] = 0;
				}
			}
		}
		
		return f[m-1][n-1];
	}
	
	
	// space optimized dp
	public int uniquePathsWithObstacles(int[][] obstacleGrid){
		if (obstacleGrid == null) return 0;
	    int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if (m == 0 || n == 0) return 0;
		
		int[] f = new int[n];
		f[0] = 1;
				
		// dp
		for (int i = 0; i < m; i++){
			for (int j = 0; j < n; j++){
				if ( obstacleGrid[i][j] == 1){
					f[j] = 0;
				} else if (j > 0){
					f[j] = f[j] + f[j-1];
				}
			}
		}
		return f[n-1];
	}
}
