package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	// method 1: use Set
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = 0;
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while ( i < s.length() && j < s.length()) {
            if (set.isEmpty() || !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                len = Math.max(len, j - i + 1);
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return len;
    }
    
	// method 2: optimized method 1 using HashMap
    public int lengthOfLongestSubstring2(String s) {
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
    
    // method 3: optimized method 2, replace Map with an integer array as direct access table
    public int lengthOfLongestSubstring3(String s) {
        int[] index = new int[256]; // the array initialized as 0, so represent string 1,2,3... rather than 0,1,2...
        int len = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            i = Math.max(i, index[s.charAt(j)]);
            len = Math.max(len, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return len;
    }
}
