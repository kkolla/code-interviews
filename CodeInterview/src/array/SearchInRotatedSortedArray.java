package array;

/*
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 */
public class SearchInRotatedSortedArray {

	public static boolean isLessThanByPosition(int[] arr, int a, int b) {
		// if a and b are in the same partition
		if (a >= arr[0] && b >= arr[0] || a <= arr[arr.length - 1]
				&& b <= arr[arr.length - 1])
			return a < b;
		else
			return a > b;
	}

	public static int search(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (a[mid] == key) return mid;
			if (a[low] <= a[mid] && a[low] <= key && key < a[mid] ||
	            a[mid] <= a[high] && !(a[mid] < key && key <= a[high]))
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = { 5, 6, 7, 9, 1, 1, 2, 3 };
		for (int i = 0; i <= 10; i++)
			System.out.println(i + ": " + search(a, i));
	}

}
