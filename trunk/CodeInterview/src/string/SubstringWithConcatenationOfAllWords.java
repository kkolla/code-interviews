package string;

import java.util.ArrayList;
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

	public static ArrayList<Integer> findSubstring(String s, String[] l) {
		ArrayList<Integer> indices = new ArrayList<Integer>();
		if (s.length() == 0 || l.length == 0 || l[0].length() == 0)
			return indices;
		int wordLength = l[0].length();
		int wordCount = l.length;
		HashSet<String> words = new HashSet<String>();
		for (String word : l) {
			words.add(word);
		}
		for (int offset = 0; offset < s.length(); offset += wordLength) {
			HashSet<String> found = new HashSet<String>();
			boolean match = true;
			for (int c = 0; c < wordCount; c++) {
				int start = offset + c * wordLength;
				int end = start + wordLength;
				String word = s.substring(start, end);
				if (words.contains(word) && !found.contains(word)) {
					found.add(word);
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
		String S = "barfoothefoobarman";
		String[] L = { "foo", "bar" };
		PrintUtils.printList(findSubstring(S, L));
	}

}
