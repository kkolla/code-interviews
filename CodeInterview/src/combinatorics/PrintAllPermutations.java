package combinatorics;

import java.util.Arrays;

import utils.PrintUtils;

public class PrintAllPermutations {

	public static void permutate(int[] s, int start) {
		if (start == s.length) {
			PrintUtils.printArray(s);
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

	public static void permutateWithoutDuplicates(int[] s, int start) {
		// how?
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 0, 0 };
		Arrays.sort(a);
		permutate(a, 0);
		permutateWithoutDuplicates(a, 0);
	}

}
