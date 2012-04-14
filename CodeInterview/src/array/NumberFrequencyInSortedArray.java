package array;

import java.util.Arrays;

import utils.CreateUtils;
import utils.PrintUtils;

public class NumberFrequencyInSortedArray {

	public static void main(String[] args) {
		int[] a = CreateUtils.createRandomIntArray(20, 10);
		Arrays.sort(a);
		int n = CreateUtils.randomNonNegative(10);
		PrintUtils.printArray(a);
		System.out.println(n);
		System.out.println(frequency(a, n));
	}

	public static int frequency(int[] a, int n) {
		int left = search(a, n, true);
		if (left == -1)
			return 0;

		int right = search(a, n, false);

		System.out.println("l=" + left + "\tr=" + right);
		return right - left + 1;
	}

	public static int search(int[] a, int n, boolean b) {
		if (a == null || b && a[0] > n || !b && a[a.length - 1] < n)
			return -1;
		if (b && a[0] == n || !b && a[a.length - 1] == n)
			return b ? 0 : a.length - 1;

		int l = 0, r = a.length - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;
			int curr = a[m];
			if (curr == n) {
				if (b && a[m - 1] < n)
					return m;
				if (!b && a[m + 1] > n)
					return m;
			}

			if (b) {
				if (curr >= n)
					r = m - 1;
				else
					l = m + 1;
			} else {
				if (curr <= n)
					l = m + 1;
				else
					r = m - 1;
			}
		}
		return -1;

	}

}
