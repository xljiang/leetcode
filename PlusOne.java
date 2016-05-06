package leetcode;

import java.util.Stack;

public class PlusOne {

	// My first solution use Stack
    public int[] plusOne(int[] digits) {
        Stack<Integer> result = new Stack<Integer>();
        int carry = 0;
        int curr;
        for (int i = digits.length - 1; i >= 0; i--){
            curr = digits[i];
            int sum;
            if (i == digits.length - 1){
                sum = curr + 1 + carry;
            } else {
                sum = curr + carry;
            }
            carry = sum / 10;
            int number = sum % 10;
            result.push(number);
        }
        if (carry != 0){
            result.push(1);
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++){
            res[i] = result.pop();
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
