package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
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
    
    
}
