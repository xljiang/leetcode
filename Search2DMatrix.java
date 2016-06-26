package leetcode;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int i = 0, j = col*row - 1;
        while (i <= j){
            int mid = i + (j-i)/2;
            if (matrix[mid / col][mid % col] == target){
                return true;
            }
            if (matrix[mid / col][mid % col] < target){
                i = mid + 1;
            } else{
                j = mid - 1;
            }
        }
        return false;
    }
}
