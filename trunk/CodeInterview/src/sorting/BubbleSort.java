package sorting;

import utils.CreateUtils;
import utils.PrintUtils;

public class BubbleSort {

	public static int[] sort(int[] a) {
		if (a == null)
			return null;
		int n = a.length;
		boolean doMore = true;
		while (doMore) {
			n--;
			doMore = false;
			for (int j = 0; j < n; j++) {
				if (a[j + 1] < a[j]) {
					int v = a[j];
					a[j] = a[j + 1];
					a[j + 1] = v;
					doMore = true;
				}
			}

		}
		return a;
	}

	public static void main(String[] args) {
		int[] a = CreateUtils.createRandomIntArray(50, 50);
		PrintUtils.printArray(a);
		PrintUtils.printArray(sort(a));
	}

}
