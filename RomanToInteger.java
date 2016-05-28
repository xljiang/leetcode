package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L',50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int number = 0;
        int tmp = map.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++){
            int curr = map.get(s.charAt(i));
            if (tmp >= curr){
                number += tmp;
            } else{
                number -= tmp;
            }
            tmp = curr;
        }
        number += tmp; // the last character in the string
        return number;
    }
}
