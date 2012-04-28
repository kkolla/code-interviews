package string;

/*
 * Given a string s consists of upper/lower-case alphabets and 
 * empty space characters ' ', return the length of last word in 
 * the string. If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of 
 * non-space characters only.
 * For example, 
 * Given s = "Hello World",
 * return 5.
 */
public class LengthOfLastWord {

	public static int lengthOfLastWord(String s) {
		int prevLength = 0;
		int currLength = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				if (currLength != 0) {
					prevLength = currLength;
					currLength = 0;
				}
			} else
				currLength++;
		}
		return currLength != 0 ? currLength : prevLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
