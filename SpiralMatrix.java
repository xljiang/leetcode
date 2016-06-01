package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (matrix.length == 0){
            return result;
        }
        
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        
        while (rowStart <= rowEnd && colStart <= colEnd){
            // move right
            for (int i = colStart; i <= colEnd; i++){
                result.add(matrix[rowStart][i]);
            }
            rowStart++;
            
            // move down
            for (int i = rowStart ; i <= rowEnd ; i++){
                result.add(matrix[i][colEnd]);
            }
            colEnd--;
            
            if (rowStart <= rowEnd){
                // move left
                for (int i = colEnd; i >= colStart ; i--){
                    result.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
            
            if (colStart <= colEnd){
                // move up
                for (int i = rowEnd; i >= rowStart; i--){
                    result.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }
        return result;
    }
}
