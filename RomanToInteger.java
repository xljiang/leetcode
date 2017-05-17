package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	
	// TLE for leetcode but ok for lintcode
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L',50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int prev = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = map.get(s.charAt(i));
            if (prev < curr) {
                result += curr - 2 * prev;
            } else {
                result += curr;
            }
            prev = curr;
        }
        
        return result;
    }
    
    // minor modification to pass leetcode
    // start from the end of the string, do not use extra 'prev' variable
    public int romanToInt2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int result = map.get(s.charAt(s.length()-1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i+1)) <= map.get(s.charAt(i))) {
                result += map.get(s.charAt(i));
            } else {
                result -= map.get(s.charAt(i));
            }
        }
        return result;
    }
    
}
