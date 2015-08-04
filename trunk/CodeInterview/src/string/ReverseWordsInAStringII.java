package string;

/**
 * 
 * Given an input string, reverse the string word by word. 
 * A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces 
 * and the words are always separated by a single space.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * Could you do it in-place without allocating extra space?
 *
 */
public class ReverseWordsInAStringII {
	
	public static void reverseWords(char[] s) {
		reverse(s, 0, s.length - 1);
		int lastWordStart = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == ' ') {
				reverse(s, lastWordStart, i - 1);
				lastWordStart = i + 1;
			}
		}
	}
	
	public static void reverseWords2(char[] s) {
		reverse(s, 0, s.length - 1);
		int start = -1, end = -1;
		for (int i = 0; i < s.length; i++) {
			if (s[i] != ' ') {
				if (start == -1) start = i;
				end = i;
			} else {
				if (start != -1) {
					reverse(s, start, end);
					start = -1;
					end = -1;
				}
			}
		}
		if (start != -1) reverse(s, start, end);
	}
	
	private static void reverse(char[] s, int start, int end) {
		while (start < end) {
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		char[] s = "   the     sky is a blue   ".toCharArray();
		reverseWords(s);
		System.out.println(s);
	}

}
