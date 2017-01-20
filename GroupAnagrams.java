package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		Arrays.sort(strs);
		for (int i = 0; i < strs.length; i++) {
			char[] c = strs[i].toCharArray();
			Arrays.sort(c);
			String key = String.valueOf(c);
			if (!map.containsKey(key)) {
				map.put(key, new LinkedList<String>());
			}
			map.get(key).add(strs[i]);
		}
		return new ArrayList<List<String>>(map.values());
	}

	// similar as method 1
	public List<List<String>> groupAnagrams2(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		for (int i = 0; i < strs.length; i++) {
			String key = sortedStr(strs[i]);
			if (map.containsKey(key)) {
				map.get(key).add(strs[i]);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(strs[i]);
				map.put(key, list);
			}
		}

		for (String key : map.keySet()) {
			result.add(map.get(key));
		}
		return result;
	}

	private String sortedStr(String str) {
		char[] c = str.toCharArray();
		Arrays.sort(c);
		String sorted = new String(c);
		return sorted;
	}
}
