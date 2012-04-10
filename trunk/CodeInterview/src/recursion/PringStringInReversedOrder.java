package recursion;

public class PringStringInReversedOrder {

	public static void printReversedString(char[] s, int i) {
		if (i == s.length)
			return;
		printReversedString(s, i + 1);
		System.out.print(s[i]);
	}

	public static void main(String[] args) {
		printReversedString("abcdefg".toCharArray(), 0);
	}

}
