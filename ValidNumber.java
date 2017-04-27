package leetcode;

public class ValidNumber {
    public boolean isNumber(String s) {
        if (s == null){
            return false;
        }
        s = s.trim();
        if (s == null || s.length() == 0){
        	return false;
        }

        if (isInteger(s)) return true;
        else if (isDecimal(s)) return true;
        else if (isExp(s)) return true;

        return false;
    }
    

    private boolean isPureNumber(String str){
        if (str.length() == 0){
            return false;
        }
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) < '0' || str.charAt(i) > '9'){
                return false;
            }
        }
        return true;
    }
    
    
    private boolean isInteger(String str){
        if (str.charAt(0) == '+' || str.charAt(0) == '-'){
            str = str.substring(1);
        }
        return isPureNumber(str);
    }
        
        
    private boolean isDecimal(String str){
        if (str.charAt(0) == '+' || str.charAt(0) == '-'){
            str = str.substring(1);
        }
        if (!str.contains(".") || str.length() < 2){
            return false;
        }
        int idx = str.indexOf('.');
        if (idx == 0 ){
            return isPureNumber(str.substring(1));
        }
        if (idx == str.length()-1){
            return isPureNumber(str.substring(0, str.length()-1));
        }
        
        String before = str.substring(0, idx);
        String after = str.substring(idx+1, str.length());
        if (isPureNumber(before) && isPureNumber(after)){
            return true;
        }
        return false;
    }

    
    private boolean isExp(String str){
        int idx = str.indexOf('e');
        if (idx == -1 || idx == str.length()-1 || idx == 0){
            return false;
        }
        String before = str.substring(0, idx);
        String after = str.substring(idx + 1);
        if ((isInteger(before) || isDecimal(before)) && isInteger(after)){
            return true;
        }
        return false;
    }
}
