package dp;

/*
 * Given a dictionary of words and a string with all spaces removed, return whether the string is composed of valid words
 * e.g
 * helloworld-> hello world (valid)
 * isitniceinhere-> is it nice in here (valid)
 * zxyy-> invalid
 */
public class StringValidityAfterChunkingToWords {

	// this can be preprocessed as constant operation
	public static boolean isInDictionary(String word) {
		String[] dict = { "hello", "world", "is", "it", "nice", "in", "here" };
		for (String s : dict)
			if (s.equals(word))
				return true;
		return false;
	}

	// v[i]: whether the substring before i (exclusive) is valid
	// v[i] = true if v[k] is true
	// and substring from k to i is a word for any k<i
	// v[i] = false if no such k exists
	// answer: v[s.length()]
	// base: v[0] = true, to test whether the sentence as whole is a word
	// complexity: O(n^2), O(n)
	public static boolean isValid(String s) {
		int length = s.length() + 1;
		boolean[] v = new boolean[length];
		v[0] = true;
		for (int i = 0; i < v.length; i++)
			for (int k = 0; k < i; k++) {
				if (v[k]) {
					String word = s.substring(k, i);
					if (isInDictionary(word)) {
						v[i] = true;
						break;
					}
				}
			}
		return v[length - 1];
	}

	public static void main(String[] args) {
		String[] ss = { "a", "is", "helloworld", "isitniceinhere", "zxyy" };
		for (String s : ss)
			System.out.println(s + " -> " + isValid(s));
	}

}
