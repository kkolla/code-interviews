package array;

public class FindClosestNumber {
	public static int search(int[] a, int key) {
		int left = 0, right = a.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (a[mid] == key)
				return a[mid];
			else if (a[mid] < key) {
				if (mid + 1 < a.length && a[mid + 1] >= key) {
					return (a[mid + 1] - key) > (key - a[mid]) ? a[mid]
							: a[mid + 1];
				} else {
					left = mid + 1;
				}
			} else {
				if (mid - 1 >= 0 && a[mid - 1] <= key) {
					return (a[mid] - key) > (key - a[mid - 1]) ? a[mid - 1]
							: a[mid];
				} else {
					right = mid - 1;
				}
			}
		}
		return left == a.length ? a[a.length - 1] : a[0];
	}

	// by an online friend..
	public static int bs(int[] input, int target) {
		int n = input.length;
		if (n == 0)
			return -1;
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int med = low + (high - low) / 2;
			int t = input[med];
			if (t == target) {
				return t;
			}
			if (t > target) {
				high = med - 1;
			} else {
				low = med + 1;
			}
		}
		if ((low < input.length && high >= 0 && target - input[high] < input[low]
				- target)
				|| low >= n) {
			return input[high];
		}
		return input[low];
	}

	public static void main(String[] args) {
		int[] a = { -5, -3, 1, 3, 7, 8, 8, 8, 9 };
		System.out.println(search(a, -4));
		System.out.println(bs(a, 11));
	}

}
