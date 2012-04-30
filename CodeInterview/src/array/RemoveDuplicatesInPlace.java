package array;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array A[] = [1,1,2],
 * Your function should return length = 2, and A[] is now [1,2].
 */
public class RemoveDuplicatesInPlace {

	public static int removeDuplicates(int[] a) {
		if (a.length == 0)
			return 0;
		int fast = 0, slow = 0;
		while (fast < a.length) {
			int curr = a[fast];
			int i = 0;
			boolean found = false;
			while (i < slow) {
				if (a[i] == curr) {
					found = true;
					break;
				}
				i++;
			}
			// if no duplicate, keep this value and increment length
			if (!found) {
				a[slow] = curr;
				slow++;
			}
			fast++;
		}
		return slow;
	}

	public static int removeDuplicatesTwiceAllowed(int[] a) {
		if (a.length == 0)
			return 0;
		int fast = 0, slow = 0;
		while (fast < a.length) {
			int curr = a[fast];
			int i = 0;
			int found = 0;
			while (i < slow) {
				if (a[i] == curr) {
					found++;
					if (found == 2) {
						break;
					}
				}
				i++;
			}
			// if duplicate<2, keep this value and increment length
			if (found < 2) {
				a[slow] = curr;
				slow++;
			}
			fast++;
		}
		return slow;
	}

	public static void main(String[] args) {
		int[] a = CreateUtils.randNonNegIntArray(20, 10);
		PrintUtils.printArray(a);
		int length = removeDuplicates(a);
		for (int i = 0; i < length; i++)
			System.out.print(a[i] + " ");
	}

}
