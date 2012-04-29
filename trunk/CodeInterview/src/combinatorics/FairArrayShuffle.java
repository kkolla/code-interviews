package combinatorics;

import utils.CreateUtils;
import utils.PrintUtils;

public class FairArrayShuffle {

	public static void swap(int[] a, int i, int j) {
		int c = a[i];
		a[i] = a[j];
		a[j] = c;
	}

	public static int[] KnuthShuffle(int[] a) {
		for (int i = a.length - 1; i > 0; i--) {
			int range = i;
			int j = (int) (Math.random() * (range + 1));
			swap(a, i, j);
		}
		return a;
	}

	public static void main(String[] args) {
		int[] a = CreateUtils.randIntArray(10, 10);
		PrintUtils.printArray(a);
		PrintUtils.printArray(KnuthShuffle(a));
	}

}
