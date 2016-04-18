package leetcode;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null){
            return 0;
        }
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            if (s.charAt(i) == ' '){
                if (len == 0){
                    continue;
                } else{
                    break;
                }
            } else {
                len++;
            }
        }
        return len;
    }
}
