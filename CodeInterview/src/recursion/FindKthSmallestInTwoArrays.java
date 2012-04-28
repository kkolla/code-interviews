package recursion;

/*
 * Given two sorted arrays and a number k, 
 * find the kth largest number in the union of the two arrays. 
 * Do it in place and in O(log n)
 * 
 * http://www.leetcode.com/2011/01/find-k-th-smallest-element-in-union-of.html
 */
public class FindKthSmallestInTwoArrays {
	public static void main(String args[]) {
		int[] a = { 2, 4, 6, 8, 10, 12, 13 };
		int[] b = { 1, 3, 7, 9, 14, 15 };
		for (int i = 1; i <= a.length + b.length; i++)
			System.out.println(i + "th: " + findKthSmallest(a, b, i));
	}

	// O(log(m) + log(n))
	public static int findKthSmallest(int[] a, int[] b, int k) {
		assert (a != null);
		assert (b != null);
		assert (a.length > 0 && b.length > 0);
		assert (k > 0 && k <= (a.length + b.length));
		return findKthSmallest(a, b, 0, a.length, 0, b.length, k);
	}

	// buggy!
	public static int findKthSmallest(int[] a, int[] b, int leftA, int lengthA,
			int leftB, int lengthB, int k) {
		// choose the middle of the first array as i
		int offset = (lengthA - 1) / 2;
		int i = leftA + offset;
		// maintain invariant i+j=k-1
		int j = leftB + k - 1 - offset;

		int prevA = i == 0 ? Integer.MIN_VALUE : a[i - 1];
		int prevB = j == 0 ? Integer.MIN_VALUE : b[j - 1];
		int currA = i == a.length ? Integer.MAX_VALUE : a[i];
		int currB = j == b.length ? Integer.MAX_VALUE : b[j];
		// k-th smallest is found
		if (currA > prevB && currA < currB)
			return currA;
		else if (currB > prevA && currB < currA)
			return currB;
		// not found, two cases
		if (currA < currB) {
			assert (currA < prevB);
			return findKthSmallest(a, b, i + 1, lengthA - offset - 1, leftB,
					(k - 1 - offset), k - offset - 1);
		} else {
			assert (currB < prevA);
			return findKthSmallest(a, b, leftA, offset, j + 1, lengthB
					- (k - 1 - offset) - 1, k - (k - 1 - offset) - 1);
		}
	}
}
