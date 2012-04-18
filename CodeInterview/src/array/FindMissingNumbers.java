package array;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * in an array of size n, there are n-k unique numbers,
 * all the numbers are in the range [0,n], find the k
 * missing numbers.
 */
public class FindMissingNumbers {

	// O(n), O(1)
	public static void findMissingNumbers(int[] a) {
		int count = a.length;
		for (int i = 0; i < count; i++) {
			int value = a[i];

		}
	}

	public static void main(String[] args) {
		int n = CreateUtils.randNonNegInt(10);
		int[] a = CreateUtils.randNonNegIntArray(n, n);
		PrintUtils.printArray(a);
		findMissingNumbers(a);
	}

}
