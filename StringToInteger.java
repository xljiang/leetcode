package leetcode;

public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null){
            return 0;
        }
        str = str.trim();
        if (str.length() == 0){
            return 0;
        }
        
        int sign = 1;
        int total = 0;
        
        // handle "+" and "-"
        if (str.charAt(0) == '+'){
            str = str.substring(1);
        } else if (str.charAt(0) == '-'){
            str = str.substring(1);
            sign = -1;
        } 
        
        // convert number and avoid overflow
        for (int i = 0; i < str.length(); i++){
            int digit = str.charAt(i) - '0';
            if (digit < 0 || digit > 9){
                break;
            }
            
            if(total > Integer.MAX_VALUE/10 || (total == Integer.MAX_VALUE/10 && digit > 7)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } 

            total = 10 * total + digit;
        }
        
        return total*sign;
    }
}
