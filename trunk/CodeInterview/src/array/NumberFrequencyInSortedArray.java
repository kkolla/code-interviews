package array;

public class NumberFrequencyInSortedArray {

	public static void main(String[] args) {
		System.out.println(frequency(new int[] { 1, 2, 2, 2, 2, 3 }, 2));
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
