package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	// O((n - c*l)*c) -- c is the number of words, l is the length of word
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		
		if (s.isEmpty() || words.length == 0) return result;
		
		Map<String, Integer> toFind = new HashMap<String, Integer>();
		for (String word: words) {
			int count = toFind.containsKey(word) ? toFind.get(word) + 1 : 1;
			toFind.put(word, count);
		}
		
		int wordLen = words[0].length(), numWords = words.length;
		int concatLen = wordLen * numWords;
		
		Map<String, Integer> found = new HashMap<String, Integer>();
		
		for (int start = 0; start <= s.length() - concatLen; start++) {
			found.clear();
			// trying to see if s.substring(start, start + concatLen) is a candidate
			int i = 0;
			for (; i < numWords; i++) {
				int wordStart = start + wordLen * i;
				int wordEnd = wordStart + wordLen;
				String word = s.substring(wordStart, wordEnd);
				if (!toFind.containsKey(word)) break;
				// the substring is a word to find, see if its count reaches the limit
				int count = found.containsKey(word) ? found.get(word) + 1 : 1;
				if (count > toFind.get(word)) break;
				found.put(word, count);
			}
			if (i == numWords) {
				// all the words are found, meaning there was a match
				result.add(start);
			}
		}
		return result;
    }

	// Time Limit Exceeded for large data in online judge
	public static ArrayList<Integer> findSubstring2(String s, String[] l) {
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
		String S = "barfoothefoobarman";
		String[] L = { "foo", "bar" };
		PrintUtils.printList(findSubstring(S, L));
	}

}
