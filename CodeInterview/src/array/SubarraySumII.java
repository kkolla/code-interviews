package array;

/**
 * Given an integer array, find a subarray where the sum of numbers is between two given interval. 
 * Your code should return the number of possible answer.
 *
 * Example
 * Given [1,2,3,4] and interval = [1,3], return 4. The possible answers are:
 * [0, 0]
 * [0, 1]
 * [1, 1]
 * [2, 2]
 */
public class SubarraySumII {
	public int subarraySumII(int[] A, int start, int end) {
        int[] subarraySums = new int[A.length + 1];
        subarraySums[0] = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            subarraySums[i + 1] = subarraySums[i] + A[i];
        }
        for (int i = 0; i < subarraySums.length - 1; i++)
            for (int j = i + 1; j < subarraySums.length; j++) {
                int diff = subarraySums[j] - subarraySums[i];
                if (diff >= start && diff <= end) count++;
            }
        return count;
    }
}
