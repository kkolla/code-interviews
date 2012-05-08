package string;


/*
 * Input: "TTwitter is nice"
 * Output: T t i e
 */
public class PrintDuplicateCharsInOrder {

	public static void print(String s) {
		int[] counts = new int[256];
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ')
				continue;
			int index = (int) s.charAt(i) - '\0';
			counts[index]++;
			if (counts[index] == 2)
				System.out.print(s.charAt(i) + " ");
		}
	}

	public static void main(String[] args) {
		print("TTwitter is nice" + Character.MIN_VALUE + Character.MIN_VALUE);
	}

}
