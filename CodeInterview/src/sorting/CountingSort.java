package sorting;

import utils.CreateUtils;
import utils.PrintUtils;

public class CountingSort {

	public static int[] sort(int[] a) {
		if (a == null)
			return null;

		// find the range
		int min = a[0];
		int max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
			if (a[i] < min)
				min = a[i];
		}
		int range = max - min + 1;

		// counting
		int[] counts = new int[range];
		for (int i = 0; i < a.length; i++) {
			counts[a[i] - min]++;
		}

		// refill
		int index = 0;
		for (int i = 0; i < range; i++) {
			for (int j = 0; j < counts[i]; j++)
				a[index++] = min + i;
		}
		return a;
	}

	public static void main(String[] args) {
		int[] a = CreateUtils.randNonNegIntArray(50, 50);
		PrintUtils.printArray(a);
		PrintUtils.printArray(sort(a));
	}

}
