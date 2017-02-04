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
            checkPanlindrome(s, i, i);// assume odd length, try to extend Palindrome as possible
            checkPanlindrome(s, i, i+1);// assume even length
        }    
        
        return s.substring(start, start + maxLength);
    }
    
    // search from middle to left and right
    private void checkPanlindrome(String s, int left, int right){
        while ((left >= 0) && (right < s.length()) && (s.charAt(left) == s.charAt(right))){
            left--;
            right++;
        }
        
        // change index to real index in the string
        left++;
        right--;
        
        // update maxLength and start index
        if (maxLength < right - left + 1){ 
            start = left;
            maxLength = right - left + 1;
        }
    }
}
