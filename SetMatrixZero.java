package leetcode;

import java.util.HashSet;

public class SetMatrixZero {

    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<Integer>();
		HashSet<Integer> cols = new HashSet<Integer>();
		int m = matrix.length; // m rows
		int n = matrix[0].length; // n cols
		for (int i = 0; i < m; i++){
			for (int j = 0; j < n; j++){
				if (matrix[i][j] == 0){
					rows.add(i);
					cols.add(j);
				}
			}
		}
		
		for (int r : rows){
			for (int j = 0; j < n; j++){
				matrix[r][j] = 0;
			}
		}
		
		for (int c : cols){
			for (int i = 0; i < m; i++){
				matrix[i][c] = 0;
			}
		}
    }
    
    // method 2: O(1) space: reuse first row and first column
    public void setZeroes2(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		// check if the first row and first column has zero first
		boolean firstRowHasZero = false;
		boolean firstColHasZero = false;
		
		for (int i = 0; i < m; i++){
			if (matrix[i][0] == 0){
				firstColHasZero = true;
				break;
			}
		}
		
		for (int j = 0; j < n; j++){
			if (matrix[0][j] == 0){
				firstRowHasZero = true;
				break;
			}
		}
		
		// start from the second row/col
		for (int i = 1; i < m; i++){
			for (int j = 1; j < n; j++){
				if (matrix[i][j] == 0){
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		
		for (int i = 1; i < m; i++){
			for (int j = 1; j < n; j++){
				if (matrix[i][0] == 0 || matrix[0][j] == 0){
					matrix[i][j] = 0;
				}
			}
		}
		
		// set first row and first col if they have zero
		if (firstRowHasZero){
			for (int j = 0; j < n; j++){
				matrix[0][j] = 0;
			}
		}
		
		if (firstColHasZero){
			for (int i = 0; i < m; i++){
				matrix[i][0] = 0;
			}
		}
    }
}
