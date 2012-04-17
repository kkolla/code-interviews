package recursion;

public class FindKthSmallestInTwoArrays {
	public static void main(String args[]) {
		int[] arr1 = { 2, 4, 6, 8, 10, 12 };
		int[] arr2 = { 1, 3, 5, 7, 9, 11 };
		System.out.println(findKthSmallest(arr1, arr2, 10));
	}

	public static int findKthSmallest(int[] arr1, int[] arr2, int k) {
		assert (arr1 != null);
		assert (arr2 != null);
		assert (arr1.length > 0 && arr2.length > 0);
		assert (k > 0 && k <= (arr1.length + arr2.length));
		return doFindKthSmallest(arr1, arr2, 0, 0, k);
	}

	public static int doFindKthSmallest(int[] arr1, int[] arr2, int strt1,
			int strt2, int k) {
		if (strt1 >= arr1.length)
			return arr2[strt2 + k - 1];
		if (strt2 >= arr2.length)
			return arr1[strt1 + k - 1];
		if (k == 1) {
			return Math.min(arr1[strt1], arr2[strt2]);
		}
		int newStrt1 = Math.min(strt1 + k / 2 - 1, arr1.length - 1);
		int newStrt2 = Math.min(strt2 + k / 2 - 1, arr2.length - 1);
		int skip = 0;
		if (arr1[newStrt1] < arr2[newStrt2]) {
			skip = newStrt1 - strt1 + 1;
			return doFindKthSmallest(arr1, arr2, newStrt1 + 1, strt2, k - skip);
		} else {
			skip = newStrt2 - strt2 + 1;
			return doFindKthSmallest(arr1, arr2, strt1, newStrt2 + 1, k - skip);
		}
	}
}
