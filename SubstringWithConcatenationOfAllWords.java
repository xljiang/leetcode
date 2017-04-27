package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {

	// This is a TLE(Time Limit Exceeded) answer
	public List<Integer> findSubstring(String s, String[] words) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int lenOfWord = words[0].length();
		int lenOfAllWords = lenOfWord * words.length;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String key : words) {
			if (map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}
		}

		for (int i = 0; i <= s.length() - lenOfAllWords; i++) {
			HashMap<String, Integer> curr = new HashMap<String, Integer>();
			int j;
			for (j = i; j < lenOfAllWords + i; j += lenOfWord) {
				String word = s.substring(j, j + lenOfWord);
				if (!map.containsKey(word))
					break;
				if (curr.containsKey(word)) {
					curr.put(word, curr.get(word) + 1);
				} else {
					curr.put(word, 1);
				}
				if (curr.get(word) > map.get(word)) {
					break;
				}
			}
			if (j == lenOfAllWords + i) {
				result.add(i);
			}
		}
		return result;
	}

	
	
	public static List<Integer> findSubstring2(String s, String[] words) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		// word length
		int wl = words[0].length();

		// create a hashmap to store words[] and word's occurrence
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String key : words) {
			if (map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}
		}
		HashMap<String, Integer> curr = new HashMap<String, Integer>();

		for (int m = 0; m < wl; m++) {
			// vars
			int i = m;
			int counter = words.length; // count down
			curr.putAll(map);

			for (int k = i; k <= (s.length() - wl); k += wl) {
				String key = s.substring(k, k + wl);
				String key_left; // left most word

				// a valid word
				if (curr.containsKey(key)) {
					// update curr
					curr.put(key, curr.get(key) - 1);
					
					// is valid word
					if (curr.get(key) >= 0){
						counter--;
					} else {
						// while the occurence of the word in curr map is less then 0
						// add the left most word count back to the curr map
						// increase counter;
						while (curr.get(key) < 0) {
							key_left = s.substring(i, i + wl);
							curr.put(key_left, curr.get(key_left) + 1);
							if (curr.get(key_left) > 0){
								counter++;
							}
							i += wl;
						}
					}

					// come to a result
					// update curr: add the left most word count back to the curr map
					if (counter == 0) {
						result.add(i);
						key_left = s.substring(i, i + wl);
						curr.put(key_left, curr.get(key_left) + 1);
						counter++;
						i += wl;
					}

				} else { // has break in string s;
					// reset curr and counter
					curr.putAll(map);
					counter = words.length;
					i = k + wl;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {

		// String[] words1 = {"bar", "foo"};
		// System.out.println(findSubstring2("barfoobarthefoobarman",
		// words1).toString());

		// String[] words2 = {"bar", "foo", "the"};
		// System.out.println(findSubstring2("barfoofoobarthefoobarman",
		// words2).toString());

		// String[] words3 = { "bar", "foo" };
		// System.out.println(findSubstring2("barfoobar", words3).toString());
	
		String[] words4 = { "bar", "foo" };
		System.out.println(findSubstring2("barfoofoofoofoobar", words4).toString());
	}

}
