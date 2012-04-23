package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import utils.PrintUtils;

/*
 * You are given a string, S, and a list of words, L, 
 * that are all of the same length. Find all starting indices 
 * of substring(s) in S that is a concatenation of each word 
 * in L exactly once and without any intervening characters.
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 */
public class SubstringWithConcatenationOfAllWords {

	// Time Limit Exceeded for large data in online judge
	public static ArrayList<Integer> findSubstring(String s, String[] l) {
		ArrayList<Integer> indices = new ArrayList<Integer>();
		if (s.length() == 0 || l.length == 0 || l[0].length() == 0)
			return indices;
		int wordLength = l[0].length();
		int wordCount = l.length;
		HashMap<String, Integer> words = new HashMap<String, Integer>();
		for (String word : l) {
			if (words.containsKey(word))
				words.put(word, words.get(word) + 1);
			else
				words.put(word, 1);
		}
		for (int offset = 0; offset < s.length(); offset += 1) {
			HashMap<String, Integer> found = new HashMap<String, Integer>();
			boolean match = true;
			for (int c = 0; c < wordCount; c++) {
				int start = offset + c * wordLength;
				int end = start + wordLength;
				if (start >= s.length() || end > s.length()) {
					match = false;
					break;
				}
				String word = s.substring(start, end);
				if (words.containsKey(word)) {
					if (!found.containsKey(word))
						found.put(word, 1);
					else {
						int count = found.get(word);
						if (count == words.get(word)) {
							match = false;
							break;
						}
						found.put(word, count + 1);
					}
				} else {
					match = false;
					break;
				}
			}
			if (match)
				indices.add(offset);
		}
		return indices;
	}

	public static void main(String[] args) {
		String S = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
		String[] L = { "fooo", "barr", "wing", "ding", "wing" };
		PrintUtils.printList(findSubstring(S, L));
	}

}
