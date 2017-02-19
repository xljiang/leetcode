package leetcode;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

	// time O(n), space O(1)
	public int numDecodings(String s){
		if (s == null || s.length() == 0) return 0;
		
		int n = s.length();
		int[] nums = new int[n+1];
		nums[0] = 1;
		nums[1] = s.charAt(0) == '0' ? 0 : 1;
		
		for (int i = 2; i <= n; i++){
			if (s.charAt(i-1) != '0'){
				nums[i] = nums[i-1];
			}
			
			int twoDigits = Integer.parseInt(s.substring(i-2, i));
			if (twoDigits >= 10 && twoDigits <= 26){
				nums[i] += nums[i-2];
			}
		}
		return nums[n];
	}
	
	// too complicated
	// dpmap(string, ways)
    public int numDecodings2(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        Map<String, Integer> dp = new HashMap<>();
        dp.put("", 1);
        dp.put("0", 0);
        for (int i = 1; i <= 9; i++) {
            String str = "" + i;
            dp.put(str, 1);
        }
        
        for (int i = 2; i <= s.length(); i++) {
            String str = s.substring(0, i); // current string
            int len = str.length();
            int lastOne = str.charAt(len-1) - '0';
            int lastTwo = Integer.parseInt(str.substring(len-2));
            int num = 0;
            if (lastOne == 0) {
                if (lastTwo <= 26 && lastTwo != 0) {
                    num = dp.get(str.substring(0, len-2));
                } else {
                    num = 0;
                }
            } else { // lastOne != 0
                if (lastTwo > 26 || lastTwo <= 9) {
                    num = dp.get(str.substring(0, len-1));
                } else {
                    num = dp.get(str.substring(0, len-1)) + dp.get(str.substring(0, len-2));
                }
            }
            dp.put(str, num);
        }
        return dp.get(s);
    }
}
