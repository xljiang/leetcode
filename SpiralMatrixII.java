package leetcode;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        if (n <= 0){
            return new int[n][];
        }
        
        int[][] result = new int[n][n];
        
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int num = 1;
        
        while (rowStart <= rowEnd && colStart <= colEnd){
            // move right
            for (int i = colStart; i <= colEnd; i++){
                result[rowStart][i] = num++;
            }
            rowStart++;
            
            // move down
            for (int i = rowStart; i <= rowEnd; i++){
                result[i][colEnd] = num++;
            }
            colEnd--;
            
            // move left
            if (colStart <= colEnd){
                for (int i = colEnd; i >= colStart; i--){
                    result[rowEnd][i] = num++;
                }
                rowEnd--;
            }
            
            // move up
            if (rowStart <= rowEnd){
                for (int i = rowEnd; i >= rowStart; i--){
                    result[i][colStart] = num++;
                }
            colStart++;
            }
        }
        
        return result;
    }
}
