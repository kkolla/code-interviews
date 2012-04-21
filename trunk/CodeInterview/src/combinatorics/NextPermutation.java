package combinatorics;

/*
 * http://wordaligned.org/articles/next-permutation#tocwhats-happening-here
 */
public class NextPermutation {

	public static void reverse(char[] s, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			char c = s[i];
			s[i] = s[j];
			s[j] = c;
		}
	}

	public static boolean nextPermutation(char[] s) {
		// if already descending sorted, return false and reverse
		int i = s.length - 2;
		while (i >= 0 && s[i] >= s[i + 1])
			i--;
		if (i == -1) {
			reverse(s, 0, s.length - 1);
			return false;
		}
		// find the first element that is greater than the pivot
		int j = s.length - 1;
		while (s[j] <= s[i])
			j--;
		// swap i and j to get a greater head
		char c = s[i];
		s[i] = s[j];
		s[j] = c;
		// reverse the remaining string to get a smaller tail
		reverse(s, i + 1, s.length - 1);
		return true;
	}

	public static void main(String[] args) {
		char[] s = "AAB".toCharArray();
		boolean undone;
		do {
			undone = nextPermutation(s);
			System.out.println(new String(s));
		} while (undone);
	}

}
