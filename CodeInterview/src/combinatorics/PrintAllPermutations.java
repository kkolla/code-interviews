package combinatorics;

import java.util.Arrays;

import utils.PrintUtils;

public class PrintAllPermutations {
	public static void swap(int[] a, int i, int j) {
		int c = a[i];
		a[i] = a[j];
		a[j] = c;
	}

	public static void permutate(int[] a, int start) {
		if (start == a.length) {
			PrintUtils.printArray(a);
			return;
		}
		for (int i = start; i < a.length; i++) {
			swap(a, i, start);
			permutate(a, start + 1);
			swap(a, i, start);
		}
	}

	public static void permutateWithoutDuplicates(int[] a) {
		Arrays.sort(a);
		permutateWithoutDuplicates(a, 0);
	}

	public static void permutateWithoutDuplicates(int[] a, int start) {
		if (start == a.length) {
			PrintUtils.printArray(a);
			return;
		}
		int last = -1;
		for (int i = start; i < a.length; i++) {
			if (a[i] == last)
				continue;
			last = a[i];
			swap(a, i, start);
			permutateWithoutDuplicates(a, start + 1);
			swap(a, i, start);
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 1 };
		// permutate(a, 0);
		permutateWithoutDuplicates(a);
	}

}
