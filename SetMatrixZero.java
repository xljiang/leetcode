package leetcode;

import java.util.HashSet;

public class SetMatrixZero {

    public void setZeroes(int[][] matrix) {
        int m = matrix[0].length; // number of cols
        int n = matrix.length; // number of rows
        HashSet<Integer> row = new HashSet<Integer>();
        HashSet<Integer> col = new HashSet<Integer>();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int r : row){
            for (int j = 0; j < m; j++){
                matrix[r][j] = 0;
            }
        }
        for (int c : col){
            for (int i = 0; i < n; i++){
                matrix[i][c] = 0;
            }
        }
    }
}
