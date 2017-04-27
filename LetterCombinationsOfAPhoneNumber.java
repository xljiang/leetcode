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
	
	// 2017-04-01 myself implementation
	// very similar as template used for subset/permutation/combination
	// just 2 loops rather than only 1 loop
    public List<String> letterCombinations5(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        helper(result, sb, digits, 0);
        return result;
    }
    
    private void helper(List<String> result, StringBuilder sb, String digits, int start) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        for (int i = start; i < digits.length(); i++) {
            String str = digitRepresent(digits.charAt(i));
            for (int j = 0; j < str.length(); j++) {
                sb.append(str.charAt(j));
                helper(result, sb, digits, i+1);
                sb.setLength(sb.length() - 1);
            }
        }
    }
    
    // convert char 1,2,3... to the string it represented
    // eg. input: '2', return: "abc" 
    private String digitRepresent(char c) {
        String str = "";
        switch(c) {
            case '1': return "";
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
            case '0': return "";
        }
        return str;
    }

}
