package leetcode;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }

        String scp = "";
        for (int i = 0; i < strs[0].length(); i++){
            for (int j = 1; j < strs.length; j++){
                if (strs[j].equals("")){
                    return "";
                }
                else if (i > strs[j].length() - 1 || strs[j].charAt(i) != strs[0].charAt(i)){ 
                    return scp;
                }
            }
            scp += strs[0].charAt(i);
        }
        return scp;
    }
}
