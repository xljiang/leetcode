package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	
	// implementation 1
	public List<String> restoreIpAddresses(String s){
        ArrayList<String> result = new ArrayList<String>();
        
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        
        ArrayList<String> ipList = new ArrayList<String>();

        recHelper(result, s, ipList, 0);
        
        return result;
    }
	
	private void recHelper(ArrayList<String> result, String s, ArrayList<String> ipList, int start){
		if (start == s.length() && ipList.size() == 4){
			add(result, ipList);
			return;
		}
		for (int i = start; i < s.length() && i <= start + 3; i++){
			String str = s.substring(start, i + 1);
			if (isValid(str)){
				ipList.add(str);
				recHelper(result, s, ipList, i + 1);
				ipList.remove(ipList.size() - 1);
			}
		}
	}
    
	// check if a str is a valid part of ip address
    private boolean isValid(String str){
    	if (str.charAt(0) == '0'){
    		return str.equals("0"); // eliminate cases such as "00", "01"
    	}
        return  Integer.valueOf(str) >= 0 && Integer.valueOf(str) <= 255;
    }
    
    // convert the ipList to a ipStr and add it to result
    private void add(ArrayList<String> result, ArrayList<String> ipList){
    	StringBuffer ipStr = new StringBuffer();
    	for (String str : ipList){
    		ipStr.append(str);
    		ipStr.append(".");
    	}
    	ipStr.deleteCharAt(ipStr.length() - 1); // remove the last "." appended by the for loop
        result.add(ipStr.toString());
    }
    
    // -------------------------------------------------------------------
    // implementation 2: 2017-04-01
    public List<String> restoreIpAddresses2(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4) return result;
        helper(result, s, "", 4);
        return result;
    }
    
    // remain: remaining string that need to be restored
    // n: how many parts need to be restored, initially 4
    private void helper(List<String> result, String remain, String path, int n) {
        if (remain.length() > n * 3) {
            return;
        }
        if (n == 0) {
            result.add(path.substring(0, path.length()-1)); // remove the last "."
            return;
        }
        
        // replaced by the following for-loop code, more concise.
        /* 
        if (remain.length() >= 1 && isValid(remain.substring(0,1)))
            helper(result, remain.substring(1), path + remain.substring(0,1) + ".", n-1);
        if (remain.length() >= 2 && isValid(remain.substring(0,2)))
            helper(result, remain.substring(2), path + remain.substring(0,2) + ".", n-1);
        if (remain.length() >= 3 && isValid(remain.substring(0,3)))
            helper(result, remain.substring(3), path + remain.substring(0,3) + ".", n-1);
        */
        for (int i = 1; i <= 3; i++) {
            if (remain.length() >= i) {
                String toAdd = remain.substring(0, i);
                if (isValidStr(toAdd)) {
                    helper(result, remain.substring(i), path + toAdd + ".", n - 1);
                }
            }
        }
    }
    
    // check if a str is a valid part of ip address
    // same as isValid method above.
    private boolean isValidStr(String str) {
        if (str.charAt(0) == '0') {
            return str.equals("0"); // eliminate cases such as "00", "01"
        }
        return Integer.parseInt(str) >= 0 && Integer.parseInt(str) <= 255; 
    }
    
}
