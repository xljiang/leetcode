package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {

	// Use extra space
    public int[] plusOne(int[] digits) {
        List<Integer> arr = new ArrayList<>();
        int carry = 1; // initialize carry = 1
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            arr.add(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) {
            arr.add(carry);
        }
        int[] res = new int[arr.size()];
        for (int i = arr.size() - 1, j = 0; i >= 0; i--, j++) {
            res[i] = arr.get(j);
        } 
        return res;
    }
	
	// A much simple solution
	public int[] plusOne2(int[] digits){
		for (int i = digits.length - 1; i >= 0; i--){
			if (digits[i] != 9){
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		
		int[] res = new int[digits.length + 1];
		res[0] = 1;
		return res;
	}
}
