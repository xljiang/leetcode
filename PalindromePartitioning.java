package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public static List<List<String>> partition(String s){
		List<List<String>> result = new ArrayList<List<String>>();
		if (s == null || s.length() == 0){
			return result;
		}
		List<String> list = new ArrayList<String>();
		recHelper(result, list, s, 0);
		return result;
	}
	
	private static void recHelper(List<List<String>> result, List<String> list, String s, int pos){
		if (pos == s.length()){
			result.add(new ArrayList<String>(list)); // dereference
			return;
		}
		for (int i = pos; i < s.length(); i++){
			String prefix = s.substring(pos, i + 1);
			if (isPalindrome(prefix)){
				list.add(prefix);
				recHelper(result, list, s, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}
	
	private static boolean isPalindrome(String str){
		if (str == null || str.length() == 0){
			return false;
		}

		for (int i = 0, j = str.length() - 1; i <= j; i++, j--){
			if (str.charAt(i) != str.charAt(j)){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("aab"));
		List<List<String>> res = partition("aab");
		System.out.println(res.toString());
		
	}
}
