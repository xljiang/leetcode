package leetcode;

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
}
