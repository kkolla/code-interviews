package array;

/**
 * Given an array contains N numbers of 0 .. N, find which number doesn't exist in the array.
 * Example
 * Given N = 3 and the array [0, 1, 3], return 2.
 * Challenge
 * Do it in-place with O(1) extra memory and O(n) time.
 *
 */
public class FindTheMissingNumber {
	public int findMissing(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int num : nums)
            sum -= num;
        return sum;
    }
}
