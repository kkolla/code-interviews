package datastructure;

import utils.CreateUtils;
import utils.PrintUtils;

// http://e-university.wisdomjobs.com/data-structures/chapter-1178-290/tries.html
public class Trie {
	char value;
	int prefixes;
	int wordsEndHere;
	Trie[] children;

	public Trie() {
		prefixes = 0;
		wordsEndHere = 0;
		children = new Trie[26]; // only deal with lower case characters;
	}

	public Trie(char c) {
		prefixes = 0;
		wordsEndHere = 0;
		children = new Trie[26];
		value = c;
	}

	// O(word.length())
	public String addWord(String word) {
		if (word.length() == 0) {
			return value + ": " + (++wordsEndHere);
		} else {
			++prefixes;
			char c = word.charAt(0);
			if (!childExists(c)) {
				setChild(c, new Trie(c));
			}
			// cut off the first character
			// suppose this can be done in O(1)
			// if C++, just do word+1
			return value + getChild(c).addWord(word.substring(1));
		}
	}

	// O(word.length())
	public void deleteWord(String word) {
		if (word.length() == 0) {
			--wordsEndHere;
		} else {
			--prefixes;
			char c = word.charAt(0);
			if (childExists(c)) {
				if (getChild(c).prefixes == 1)
					setChild(c, null);
				else
					getChild(c).deleteWord(word.substring(1));
			}
		}
	}

	// O(1)
	public Trie setChild(char c, Trie t) {
		Trie old = children[c - 'a'];
		children[c - 'a'] = t;
		return old;
	}

	// worst: O(word.length()), best: O(1)
	public int countWord(String word) {
		if (word.length() == 0) {
			return wordsEndHere;
		} else {
			char c = word.charAt(0);
			return childExists(c) ? getChild(c).countWord(word.substring(1))
					: 0;
		}
	}

	// worst: O(prefix.length()), best: O(1)
	public int countPrefix(String prefix) {
		if (prefix.length() == 0) {
			return prefixes;
		} else {
			char c = prefix.charAt(0);
			return childExists(c) ? getChild(c)
					.countPrefix(prefix.substring(1)) : 0;
		}
	}

	// worst: ?, best: O(1)
	public int countWordAllowingMissingLetters(String word, int missing) {
		if (word.length() == 0) {
			return wordsEndHere;
		} else {
			char c = word.charAt(0);
			if (!childExists(c)) {
				if (missing > 0) {
					// child not existing, count current letter as missing
					return countWordAllowingMissingLetters(word.substring(1),
							missing - 1);
				} else {
					// no more missing letters are allowed
					return 0;
				}
			} else {
				// two ways to deal with allowing missing letter
				int count = 0;
				// 1. count current letter as missing
				if (missing > 0)
					count += countWordAllowingMissingLetters(word, missing - 1);
				// 2. count current letter as satisfying
				count += getChild(c).countWordAllowingMissingLetters(
						word.substring(1), missing);
				return count;
			}
		}
	}

	// O(1)
	public boolean childExists(char c) {
		return getChild(c) != null;
	}

	// O(1)
	public Trie getChild(char c) {
		return children[c - 'a'];
	}

	public static void main(String[] args) {
		Trie root = new Trie();
		String[] words = CreateUtils.randStringArray(50, 10, false);
		PrintUtils.printArray(words);
		for (int i = 0; i < words.length; i++) {
			root.addWord(words[i]);
		}
		System.out.println("words in dictionary: " + root.prefixes);
		String[] prefixes = CreateUtils.randStringArray(20, 3, false);
		for (int i = 0; i < prefixes.length; i++) {
			System.out.println("prefix count for '" + prefixes[i] + "': "
					+ root.countPrefix(prefixes[i]));
		}
		String[] queries = CreateUtils.randStringArray(20, 10, false);
		for (int i = 0; i < queries.length; i++) {
			int missing = CreateUtils.randNonNegInt(queries[i].length());
			System.out
					.println("word count for '"
							+ queries[i]
							+ "' allowing "
							+ missing
							+ " missing: "
							+ root.countWordAllowingMissingLetters(queries[i],
									missing));
		}
		for (int i = 0; i < words.length; i++) {
			root.deleteWord(words[i]);
			System.out.println("deleting word '" + words[i]
					+ "', count after deletion: " + root.countWord(words[i]));
		}
		System.out.println("words in dictionary: " + root.prefixes);
	}
}
