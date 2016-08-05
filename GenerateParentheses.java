package leetcode;

import java.util.ArrayList;
import java.util.List;

// cc150 9-6
public class GenerateParentheses {
	
	// method 1: 1) add "()" to the end of string, 2) add "()" after every "(" and check duplicates 
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n == 1){
            result.add("()");
        } else {
            List<String> prevlist = generateParenthesis(n - 1);
            for (String str : prevlist){
                String newstr1 = str + "()";
                if (!result.contains(newstr1)){
                    result.add(newstr1);
                }
                for (int i = 0; i < str.length(); i++){
                    if (str.charAt(i) == '('){
                        String newstr2 = str.substring(0, i+1) + "()" + str.substring(i+1);
                        if (!result.contains(newstr2)){
                            result.add(newstr2);
                        }
                    }
                }
            }
        }
        return result;
    }
    
    // method 2: use template
    public List<String> generateParenthesis2(int n){
    	ArrayList <String> result = new ArrayList<String>();
    	
    	if (n <= 0){
    		return result;
    	}
    	
    	recHelper(result, "", n, n);
    	return result;
    }
    
    private void recHelper(ArrayList<String> result, 
    					   String paren, // current paren
    					   int left, 	// how many left paren we need to add
    					   int right){	// how many right paren we need to add
    	
    	if (left == 0 && right == 0){
    		result.add(paren);
    		return;
    	}
    	
    	if (left > 0){
    		recHelper(result, paren + "(", left - 1, right);
    	}
    	if (right > 0 && left < right){
    		recHelper(result, paren + ")", left, right - 1);
    	}
    }
}
