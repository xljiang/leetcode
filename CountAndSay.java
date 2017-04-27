package leetcode;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n <= 1){
            return "1";
        }
        String curr = "1";
        for (int i = 1; i < n; i++){
            curr = say(curr);
        }
        return curr;
    }
    
    private String say(String str){
        String res = "";
        int count = 1;
        int i = 0;
        while (i < str.length()){
            int j = i + 1;
            while (j < str.length() && str.charAt(i) == str.charAt(j)){
                j++;
                count++;
            }
            res += count;
            res += str.charAt(i);
            i = j;
            count = 1;
        }
        return res;
    }
}
