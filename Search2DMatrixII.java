package leetcode;

public class Search2DMatrixII {

	public boolean searchMatrix(int[][] matrix, int target) {
		int n = matrix[0].length; // cols
		int lo = 0, hi = matrix.length - 1; // row numbers
		
		// find the largest row number (end), which satisfy matrix[row][0] < target
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (matrix[mid][0] == target) {
				return true;
			} else if (matrix[mid][0] < target) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		int end = hi;
		
		// reset hi & lo
		lo = 0;
		hi = matrix.length - 1; 
		
		// find the smallest row number (start), which satisfy matrix[row][n-1] > target
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (matrix[mid][n-1] == target) {
				return true;
			} else if (matrix[mid][n-1] < target) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		int start = lo;
		
		// binary search in each row
		for (int i = start; i <= end; i++) {
			if (searchArray(matrix[i], target)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean searchArray(int[] array, int target) {
		int i = 0, j = array.length;
		while ( i <= j) {
			int mid = i + (j - i) / 2;
			if (array[mid] == target) {
				return true;
			} else if (array[mid] > target) {
				j = mid - 1;
			} else {
				i = mid + 1;
			}
		}
		return false;
	}
	
	// method 2: O(m+n)
	public boolean searchMatrix2(int[][] matrix, int target) {
		int row = 0, col = matrix[0].length - 1;
		while (row < matrix.length && col >= 0) {
			if (matrix[row][col] == target) {
				return true; 
			} else if (matrix[row][col] > target) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}
}
