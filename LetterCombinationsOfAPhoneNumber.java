package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

	// method 1: DFS
	public List<String> letterCombinations(String digits) {
		String digitLetter[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    	ArrayList<String> result = new ArrayList<String>();
    	
        if (digits == null || digits.isEmpty()){
            return result;
        }
        
        result.add("");
        for (int i = 0; i < digits.length(); i++){
        	result = combine(digitLetter[digits.charAt(i) - '0'], result);
        }
        
        return result;
        
    }
    
    private ArrayList<String> combine(String str, ArrayList<String> result){
    	ArrayList<String> newResult = new ArrayList<String>();
    	for (String s : result){
    		for (int i = 0; i < str.length(); i++){
    			newResult.add(s + str.charAt(i));
    		}
    	}
    	return newResult;
    }

    // method 2: BFS （not easy)
    
    // method 3: use template, backtracking (this method is slower than method 1)
	public List<String> letterCombinations3(String digits) {
    	ArrayList<String> result = new ArrayList<String>();
    	
        if (digits == null || digits.isEmpty()){
            return result;
        }
        
        String digitLetter[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        recHelper(digitLetter, digits, sb, result);
        return result;
    }
    
	private void recHelper(String[] digitLetter, String digits, StringBuilder sb, ArrayList<String> result){
		if (sb.length() == digits.length()){
			result.add(sb.toString());
			return;
		}
		String letters = digitLetter[digits.charAt(sb.length()) - '0'];
		for (int i = 0; i < letters.length(); i++){
			sb.append(letters.charAt(i));
			recHelper(digitLetter, digits, sb, result);
			sb.deleteCharAt(sb.length() - 1); // backtracking
		}
	}
	
	// method 4: use template, another way of backtracking
	public List<String> letterCombinations4(String digits) {
    	ArrayList<String> result = new ArrayList<String>();
    	
        if (digits == null || digits.isEmpty()){
            return result;
        }
        
        String digitLetter[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        recHelper4(digitLetter, digits, "", result, 0);
        return result;
    }
    
	private void recHelper4(String[] digitLetter, String digits, String str, ArrayList<String> result, int pos){
		if (pos == digits.length()){
			result.add(str);
			return;
		}
		String letters = digitLetter[digits.charAt(pos) - '0'];
		for (int i = 0; i < letters.length(); i++){
			recHelper4(digitLetter, digits, str + letters.charAt(i), result, pos + 1);
		}
	}

}
