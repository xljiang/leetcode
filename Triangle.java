package leetcode;

import java.util.List;

public class Triangle {
	
	// top-down (not straightforward)
	public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
        	return -1;
        }
        if (triangle.get(0) == null || triangle.get(0).size() == 0){
        	return -1;
        }
        
        // state: f[x][y] = minimum path value from 0,0 to x,y
        int n = triangle.size();
        int[][] f = new int[n][n];
        
        // initialize
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++){
        	f[i][0] = f[i-1][0] + triangle.get(i).get(0);
        	f[i][i] = f[i-1][i-1] + triangle.get(i).get(i);
        }
        
        // top down
        for (int i = 1; i < n; i++){
        	for (int j = 1; j < i; j++){
        		f[i][j] = Math.min(f[i-1][j], f[i-1][j-1]) + triangle.get(i).get(j);
        	}
        }
        
        // answer
        int best = f[n-1][0];
        for (int i = 1; i < n; i++){
        	best = Math.min(best, f[n-1][i]);
        }
        return best;
    }
	
	
	// bottom up (straightforward)
	public int minimumTotalBottomUp(List<List<Integer>> triangle){
        if (triangle == null || triangle.size() == 0){
        	return -1;
        }
        if (triangle.get(0) == null || triangle.get(0).size() == 0){
        	return -1;
        }
        
        // state: f[x][y] = minimum path value from x,y to bottom
        int n = triangle.size();
        int[][] f = new int[n][n];
        
        // initialize
        for (int i = 0; i < n; i++){
        	f[n-1][i] = triangle.get(n-1).get(i);
        }
        
        // bottom up
        for (int i = n-2; i >= 0; i--){ // for each layer
        	for (int j = 0; j <= i; j++){  // check its every node
        		// find the lesser of its two children, and sum the current value in the triangle with it.
        		f[i][j] = Math.min(f[i+1][j], f[i+1][j+1]) + triangle.get(i).get(j);
        	}
        }
        
        // answer
        return f[0][0];
	}
	
	// bottom up with space optimization
	public int minimumTotalBottomUpOpt(List<List<Integer>> triangle){
        if (triangle == null || triangle.size() == 0){
        	return -1;
        }
        if (triangle.get(0) == null || triangle.get(0).size() == 0){
        	return -1;
        }
        
        // state: f[x][y] = minimum path value from x,y to bottom
        int n = triangle.size();
        int[] f = new int[n];
        
        // initialize
        for (int j = 0; j < triangle.get(n-1).size(); j++){
        	f[j] = triangle.get(n-1).get(j);
        }
        
        // bottom up
        for (int i = n-2; i >= 0; i--){ // for each row, start from second last row
        	for (int j = 0; j <= i; j++){  // go through each node
        		// pick the smaller one of next row and add it up to current level.
        		f[j] = Math.min(f[j], f[j+1]) + triangle.get(i).get(j);
        	}
        }
        
        // answer
        return f[0];
	}
}
