package dp;

/*
 * Find the contiguous subarray within an array 
 * containing at least one number which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarraySum {

	public static int maxSum(int[] a) {
		int sum = 0;
		int maxSum = a[0];
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (sum > maxSum)
				maxSum = sum;
			if (sum < 0) // pitfall: not else if
				sum = 0;
		}
		return maxSum;
	}

	public static void main(String[] args) {
		System.out.println(maxSum(new int[] { -3, -2, 0, -1 }));
	}

}
