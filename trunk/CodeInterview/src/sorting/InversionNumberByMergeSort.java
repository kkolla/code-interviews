package sorting;

import utils.PrintUtils;

public class InversionNumberByMergeSort {

	// returns the number of inversion pairs
	// normally returns nothing for merge sort
	public static int merge(int[] a, int start1, int start2, int end,
			int inversions) {
		int[] b = new int[end - start1 + 1];
		int i = start1, j = start2, k = 0;
		while (i <= start2 - 1 && j <= end) {
			if (a[i] <= a[j]) {
				b[k++] = a[i++];
			} else {
				inversions += (start2 - i);
				b[k++] = a[j++];
			}
		}
		while (i <= start2 - 1)
			b[k++] = a[i++];
		while (j <= end)
			b[k++] = a[j++];
		for (i = start1, j = 0; i <= end; i++, j++)
			a[i] = b[j];
		return inversions;
	}

	public static int mergeSort(int[] a, int low, int high, int inversions) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			inversions = mergeSort(a, low, mid, inversions);
			inversions = mergeSort(a, mid + 1, high, inversions);
			inversions = merge(a, low, mid + 1, high, inversions);
		}
		return inversions;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 6, 1, 5, 2, 8 };
		PrintUtils.printArray(arr);
		System.out
				.println("inversions:" + mergeSort(arr, 0, arr.length - 1, 0));
		PrintUtils.printArray(arr);

		arr = new int[] { 9, 1, 0, 5, 4 };
		PrintUtils.printArray(arr);
		System.out
				.println("inversions:" + mergeSort(arr, 0, arr.length - 1, 0));
		PrintUtils.printArray(arr);

		arr = new int[] { 9, 8, 7, 6, 5, 4, 3, 1, 2 };
		PrintUtils.printArray(arr);
		System.out
				.println("inversions:" + mergeSort(arr, 0, arr.length - 1, 0));
		PrintUtils.printArray(arr);
	}

}
