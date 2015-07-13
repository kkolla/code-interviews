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
		int prevLength = 0, currLength = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				if (currLength != 0)
					prevLength = currLength;
				currLength = 0;
			} else
				currLength++;
		}
		return currLength != 0 ? currLength : prevLength;
	}
	
	public static int lengthOfLastWord2(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') i--;
        if (i == -1) return 0;
        int end = i;
        while (i >= 0 && s.charAt(i) != ' ') i--;
        return end - i;
    }

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello   World  haha  "));
	}

}
