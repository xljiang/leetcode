package leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int max = 0;
        // hashmap<char, index of the char>
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int l = 0, r = 0; r < s.length(); r++){
            if (map.containsKey(s.charAt(r))){
                l = Math.max(l, map.get(s.charAt(r)) + 1);
            } 
            map.put(s.charAt(r), r);
            max = Math.max(max, r-l+1);
        }
        return max;
    }
}
