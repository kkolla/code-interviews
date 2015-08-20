package array;

/**
 * Given an integer array, heapify it into a min-heap array.
 * For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] 
 * is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
 * Example
 * Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.
 * Challenge
 * O(n) time complexity
 *
 */
public class Heapify {
	// O(n)?
	public void heapify(int[] A) {
        for (int i = A.length / 2; i >= 0; i--) {
            heapify(A, i);
        }
    }
    
    private void heapify(int[] A, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        while (left < A.length || right < A.length) {
            int leftVal = left < A.length ? A[left] : Integer.MAX_VALUE;
            int rightVal = right < A.length ? A[right] : Integer.MAX_VALUE;
            int child = leftVal <= rightVal ? left : right;
            if (A[i] < A[child]) break;
            else {
                int temp = A[i];
                A[i] = A[child];
                A[child] = temp;
                i = child;
                left = 2 * i + 1;
                right = 2 * i + 2;
            }
        }
    }
}
