package leetcode;

public class ImplementStrStr {

	public int strStr(String haystack, String needle){
		if (needle == null || haystack == null){
			return -1;
		}
		if (needle.length() == 0){
			return 0;
		}
		for (int i = 0; i < haystack.length(); i++){
			if (haystack.charAt(i) == needle.charAt(0)){
				int k = i;
				if ( haystack.length() - k < needle.length()){
					return -1;
				}
				boolean sameCharacter = true;
				for (int j = 0; j < needle.length(); k++, j++){
					if (haystack.charAt(k) != needle.charAt(j)){
						sameCharacter = false;
						break;
					}
				}
				if (sameCharacter){
					return i;
				} 
			}
		}
		return -1;
	}
}
