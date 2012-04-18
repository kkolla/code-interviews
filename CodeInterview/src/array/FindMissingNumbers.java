package array;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * in an array of size n, there are n-k unique numbers,
 * all the numbers are in the range [0,n-1], find the k
 * missing numbers.
 */
public class FindMissingNumbers {

	// O(n), O(1)
	public static void findMissingNumbers(int[] a) {
		int count = a.length;
		for (int i = 0; i < count; i++) {
			int index = a[i];
			// this element has been marked, restore it
			if (index < 0)
				index += count;
			// if new, mark the element
			if (a[index] >= 0)
				a[index] -= count;
			// else just keep it because it is already marked
		}
		PrintUtils.printArray(a);
		for (int i = 0; i < count; i++) {
			// unmarked element are missing
			if (a[i] >= 0)
				System.out.println(i + " is missing");
			// restore its original value
			else
				a[i] += count;
		}
		PrintUtils.printArray(a);
	}

	public static void main(String[] args) {
		int n = CreateUtils.randNonNegInt(10);
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = CreateUtils.randNonNegInt(n);
		PrintUtils.printArray(a);
		findMissingNumbers(a);
	}

}
