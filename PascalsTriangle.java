package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	// iteration
	public List<List<Integer>> generate(int numRows){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (numRows <= 0){
			return result;
		}
		
		List<Integer> prevlist = new ArrayList<Integer>();
		prevlist.add(1);
		result.add(prevlist);
		for (int i = 1; i < numRows; i++){
			List<Integer> list = new ArrayList<Integer>();
			list.add(1);
			for (int j = 1; j < i; j++){
				list.add(prevlist.get(j - 1) + prevlist.get(j));
			}
			list.add(1);
			result.add(list);
			prevlist = list;
		}
		return result;
	}
	
	// more concise iteration
	public List<List<Integer>> generate2(int numRows){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (numRows <= 0){
			return result;
		}
		
		for (int i = 0; i < numRows; i++){
			List<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < i + 1; j++){
				if (j == 0 || j == i){
					list.add(1);
				} else {
					list.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
				}
			}
			result.add(list);
		}
		return result;
	}
}
