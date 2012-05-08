package sorting;

import utils.PrintUtils;

/*Given  an integer array and a specific integer x, write a program to do a three-partition.
 That is, the left part of the array is less than x, the middle part is equal to x and
 the right part is bigger than x
 E.g     array: 0 1 2 1 2 1 2 0 0 2 1 0 0 2 2 1 0  ==>  0 0 0 0 0 0 1 1 1 1 1 2 2 2 2 2 2 
 */

public class DutchFlagProblem {

	public static int[] sort(int[] a, int middle) {
		int less = 0;
		int greater = a.length - 1;
		for (int i = 0; i <= greater;) { // pitfall: not <
			if (a[i] < middle) {
				int temp = a[i];
				a[i] = a[less];
				a[less] = temp;
				less++;
				i++;
			} else if (a[i] > middle) {
				int temp = a[i];
				a[i] = a[greater];
				a[greater] = temp;
				greater--;
			} else {
				i++;
			}
		}
		return a;
	}

	public static int[] dutchFlagSort(int[] a) {
		for (int i = 0, small = 0, large = a.length - 1; i <= large;) {
			if (a[i] == 0) {
				swap(a, small, i);
				small++;
				i++;
			} else if (a[i] == 2) {
				swap(a, large, i);
				large--;
			} else {
				i++;
			}
		}
		return a;
	}

	public static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 1, 2, 1, 2, 0, 0, 2, 1, 0, 0, 2, 2, 1, 0 };
		PrintUtils.printArray(a);
		PrintUtils.printArray(sort(a, 1));
		a = new int[] { 0, 1, 0, 0, 1, 0, 0, 1, 0 };
		PrintUtils.printArray(dutchFlagSort(a));
	}
}
