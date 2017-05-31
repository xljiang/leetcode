package leetcode;

public class LongestPalindromicSubstring {
	// method 1: brute force (TLE), O(n^3) time
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (isPalindrome(s, i, j)) {
                    if (j-i+1 > maxLen) {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // method 2: extend around center O(n^2) time, O(1) space
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) return "";
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = extendAroundCenter(s, i, i); // odd length
            int len2 = extendAroundCenter(s, i, i+1); // even length
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                start = i - (len-1)/2;
            }
        }
        return s.substring(start, start + maxLen);
    }
    
    // extend as much as possible
    private int extendAroundCenter(String s, int left, int right) {
        if (left >= s.length() || right >= s.length()) return 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return right-left-1;
    }
    
    // method 3: O(n^2) time, O(1) space
    public String longestPalindrome3(String s) {
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i - maxLen - 1, i)) {
                start = i - maxLen - 1;
                maxLen += 2;
            } else if (isPalindrome(s, i - maxLen, i)) {
                start = i - maxLen;
                maxLen += 1;
            }
        }
        return s.substring(start, start + maxLen);
    }
    
    /* isPalindrome() method is the same as that in method 1 */

}
