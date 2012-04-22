package array;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class FindFirstMissingPositive {

	public static int find(int[] a) {
		for (int i = 0; i < a.length; i++) {
			while (a[i] != i + 1) {
				if (!(a[i] <= 0 || a[i] > a.length || a[i] == a[a[i] - 1])) {
					int temp = a[i];
					a[i] = a[temp - 1];
					a[temp - 1] = temp;
				} else {
					break;
				}
			}
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] != i + 1)
				return i + 1;
		}
		return a.length + 1;
	}

	public static void main(String[] args) {
		int[] a = CreateUtils.randIntArray(10, 10);
		PrintUtils.printArray(a);
		System.out.println(find(a));
	}

}
