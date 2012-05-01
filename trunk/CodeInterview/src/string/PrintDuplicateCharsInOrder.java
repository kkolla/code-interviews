package string;

import java.util.HashMap;

/*
 * Input: "TTwitter is nice"
 * Output: T t i e
 */
public class PrintDuplicateCharsInOrder {

	public static void print(String s) {
		int[] counts = new int[256];
		for (int i = 0; i < s.length(); i++) {
			int index = (int) s.charAt(i) + 128;
			if (s.charAt(i) != ' ' && counts[index] == 1)
				System.out.print(s.charAt(i) + " ");
			counts[index]++;
		}
		HashMap b;
	}

	public static void main(String[] args) {
		print("TTwitter is nice" + Character.MIN_VALUE + Character.MIN_VALUE);
	}

}
