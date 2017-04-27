package leetcode;


public class MinimumWindowSubstring {

	// TLE
	// if find the first char that in s and also in t, start while loop
	// subT is the part of T after delete the found char in string s. 
	// update newResult every time in the while loop
	// after while loop finished, compare newResult and result, then decide to if update result
	public static String minWindow(String s, String t){
		String result = "";
		
		for (int i = 0; i < s.length(); i++){
			int index = t.indexOf(s.charAt(i));
			if (index != -1){
				int k = i;
				StringBuilder subT = new StringBuilder(t);
				String newResult = "";
				while (subT.length() != 0){
					int tIndex = subT.indexOf("" + s.charAt(k));
					if (tIndex != -1){
						subT.deleteCharAt(tIndex);
					}
					newResult += s.charAt(k);
					k++;
					if (k == s.length()){
						break;
					}
				}
				if (subT.length() == 0){
					if (result.isEmpty()){
						result = newResult;
					}
					else if (newResult.length() < result.length()){
						result = newResult;
					}
				}
			}
		}
		
		return result;
	}
	
	// a very brilliant solution!!!
	// Can be used as a template for 2 pointer problems!
	public static String minWindow2(String s, String t){
		if ( s == null || s.isEmpty() || t == null || t.isEmpty()){
			return "";
		}
		
		
		// create a hashmap to store string t and its occurrence.
		int Tmap[] = new int[256];
		for (int j = 0; j < t.length(); j++){
			Tmap[t.charAt(j)]++;
		}
		
		int i = 0;	// first pointer of s	(head)
		int k = 0;  // second pointer of s （to tail)
		int counter = t.length();
		int d = Integer.MAX_VALUE; // length of the result string
		int head = 0; // head index of the result string
		
		while (k < s.length()){
			if (Tmap[s.charAt(k)] > 0){
				counter--;
			}
			Tmap[s.charAt(k)]--;  // occurrence minus 1
			k++;
			System.out.println("k"+k);
			while (counter == 0){
				if (k - i < d){
					head = i;
					d = k - i;
				}
				if (Tmap[s.charAt(i)] == 0){
					counter++;
				}
				Tmap[s.charAt(i)]++;
				i++;
				System.out.println("i:" + i);
				System.out.println("head: " + head);
				System.out.println("d: " + d);
			}
		}
		if (d != Integer.MAX_VALUE){
			return s.substring(head, head + d);
		}
		return "";
	}
	
	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		String r = minWindow2(s, t);
		System.out.println(r);
	}

}
