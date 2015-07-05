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
		int[] b = { 1, 3, 7, 8, 8, 14, 15 };
		for (int i = 1; i <= a.length + b.length; i++)
			System.out.println(i + "th: " + findKthSmallest(a, b, 0, 0, i));
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
	
	// http://yucoding.blogspot.com/2013/01/leetcode-question-50-median-of-two.html
	public static int findKthSmallest(int[] a, int[] b, int leftA, int leftB, int k) {
		int lenA = a.length - leftA;
		int lenB = b.length - leftB;
		if (lenA > lenB) return findKthSmallest(b, a, leftB, leftA, k);
		
		// if the smaller array is empty, return the k-th element from the bigger array
		if (lenA == 0) return b[leftB + k - 1];	
		// if both arrays are non-empty and k = 1, the k-th element is the smaller of the first elements
		if (k == 1) return Math.min(a[leftA], b[leftB]);
		
		// cut the arrays by two halves of size k/2
		int offsetA = Math.min(k / 2, lenA);
		int indexA = leftA + offsetA - 1;
		int indexB = leftB + k - offsetA - 1;
		
		if (a[indexA] <= b[indexB])
			// because the largest element in the half of A is smaller than 
			// the largest element in the half of B, it means the k-th smallest
			// element must not exist in the half of A
			return findKthSmallest(a, b, indexA + 1, leftB, k - offsetA);
		else
			// similarly, the k-th element must not exist in the half of B
			return findKthSmallest(a, b, leftA, indexB + 1, offsetA);
	}
}
