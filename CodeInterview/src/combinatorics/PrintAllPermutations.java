package combinatorics;

public class PrintAllPermutations {

	public static void permutate(int[] s, int start) {
		if (start == s.length) {
			for (int i = 0; i < s.length; i++)
				System.out.print(s[i]);
			System.out.println();
			return;
		}
		for (int i = start; i < s.length; i++) {
			int c = s[start];
			s[start] = s[i];
			s[i] = c;
			permutate(s, start + 1);
			c = s[start];
			s[start] = s[i];
			s[i] = c;
		}
	}

	public static void main(String[] args) {
		permutate(new int[] { 1, 2, 3, 4, 5 }, 0);
	}

}
