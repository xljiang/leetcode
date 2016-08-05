package leetcode;

public class LongestPalindromicSubstring {
	// ivars
    int maxLength, start;
    
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()){
            return "";
        }
        if (s.length() == 1){
            return s;
        }
        
        for (int i = 0; i < s.length() - 1; i++){
            checkPanlindrome(s, i, i);
            checkPanlindrome(s, i, i+1);
        }    
        
        return s.substring(start, start + maxLength);
    }
    
    private void checkPanlindrome(String s, int j, int k){
        while ((j >= 0) && (k < s.length()) && (s.charAt(j) == s.charAt(k))){
            j--;
            k++;
        }
        
        // change index to real index in the string
        j++;
        k--;
        
        // update maxLength and start index
        if (maxLength < k - j + 1){ 
            start = j;
            maxLength = k - j + 1;
        }
    }
}
