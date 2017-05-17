package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ReverseWordsInAString {
	
	// use hashmap to store words
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        Map<Integer, StringBuilder> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
        	if (i == s.length() - 1 && s.charAt(i) != ' ') {
        		sb.append(s.charAt(i));
        		map.put(map.size(), sb);
        	} else if (s.charAt(i) == ' ') {
                if (sb.length() != 0) {
                    map.put(map.size(), sb);
                }
                sb = new StringBuilder();
            } else {
                sb.append(s.charAt(i));
            }
        }
        if (map.size() == 0) return "";
        StringBuilder res = new StringBuilder();
        for (int i = map.size() - 1; i >= 0; i--) {
            res.append(map.get(i));
            res.append(' ');
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
    
    // use split function
    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        if (array.length == 0) return "";
        
        for (int i = array.length - 1; i >= 0; i--) {
            if (!array[i].equals("")) {
                sb.append(array[i]).append(' ');
            }
        }
        
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    
}
