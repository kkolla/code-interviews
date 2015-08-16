package array;

import java.util.Arrays;

/*
 * Given two array of integers(the first array is array A, the second array is array B), now we are going to find a element in array A which is A[i], and another element in array B which is B[j], so that the difference between A[i] and B[j] (|A[i] - B[j]|) is as small as possible, return their smallest difference.
 * Example
 * For example, given array A = [3,6,7,4], B = [2,8,9,3], return 0
 */
public class TheSmallestDifference {
	public int smallestDifference(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0, j = 0, smallestDiff = Integer.MAX_VALUE;
        while (i < A.length && j < B.length) {
            int a = i < A.length ? A[i] : A[A.length - 1];
            int b = j < B.length ? B[j] : B[B.length - 1];
            smallestDiff = Math.min(smallestDiff, Math.abs(a - b));
            if (a < b) i++;
            else j++;
        }
        
        int k = i < A.length ? i : j;
        int[] C = i < A.length ? A : B;
        int lastElem = i < A.length ? B[B.length - 1] : A[A.length - 1];
        while (k < C.length) {
            smallestDiff = Math.min(smallestDiff, Math.abs(C[k] - lastElem));
            k++;
        }
        
        return smallestDiff;
    }
}
