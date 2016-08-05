package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

	// method 1
	public List<Integer> getRow(int rowIndex){
		List<Integer> prevRow = new ArrayList<Integer>();
		if (rowIndex < 0){
			return prevRow;
		}
		prevRow.add(1);
		List<Integer> row = prevRow;
		
		for (int i = 1; i < rowIndex + 1; i++){
			row = new ArrayList<Integer>();
			for (int j = 0; j < i + 1; j++){
				if (j == 0 || j == i){
					row.add(1);
				} else{
					row.add(prevRow.get(j-1) + prevRow.get(j));
				}
			}
			prevRow = row;
		}
		return row;
	}
	
	// method 2, O(k) extra space
	public List<Integer> getRow2(int rowIndex){
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < rowIndex + 1; i++){
			// System.out.println("i" + i);
			result.add(1);
			// System.out.println(result.toString());
			for (int j = i - 1; j > 0; j--){
				result.set(j, result.get(j-1) + result.get(j));
				// System.out.println(result.toString());
			}
		}
		return result;
	}
	
	/* output of method 2
	i0
	[1]
	i1
	[1, 1]
	i2
	[1, 1, 1]
	[1, 2, 1]
	i3
	[1, 2, 1, 1]
	[1, 2, 3, 1]
	[1, 3, 3, 1]
	i4
	[1, 3, 3, 1, 1] 	// result.add(1)
	[1, 3, 3, 4, 1] 	// j=3
	[1, 3, 6, 4, 1] 	// j=2
	[1, 4, 6, 4, 1] 	// j=1
	i5
	[1, 4, 6, 4, 1, 1]
	[1, 4, 6, 4, 5, 1]
	[1, 4, 6, 10, 5, 1]
	[1, 4, 10, 10, 5, 1]
	[1, 5, 10, 10, 5, 1]
	*/
}
