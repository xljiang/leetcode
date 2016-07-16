package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	// method 1: recursion
	public List<Integer> grayCode(int n){
		List<Integer> rst = new ArrayList<Integer>();
		if (n == 0){
			rst.add(0);
			return rst;
		}
		
		rst = grayCode(n-1);
		
		for (int i = rst.size() - 1; i >= 0; i--){
			int num = rst.get(i);
			num += 1 << (n-1);
			rst.add(num);
		}
		
		return rst;
	}

	// method 2: math: G(i) = i ^ (i/2)
	public List<Integer> grayCodeMath(int n){
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < 1<<n; i++){
			result.add(i ^ i>>1);
		}
		return result;
	}
}
