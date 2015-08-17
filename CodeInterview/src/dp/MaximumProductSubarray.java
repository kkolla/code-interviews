package dp;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 *
 */
public class MaximumProductSubarray {
	
	public static int maxProduct(int[] nums) {
		int max = nums[0], min = nums[0]; // local: max/min product ending nums[i]
        int result = nums[0]; // global
		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			int temp = max;
			max = Math.max(num, Math.max(max * num, min * num));
			min = Math.min(num, Math.min(temp * num, min * num));
			result = Math.max(result, max);
		}
		return result;
    }

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] {2, 3, -2, 4}));
	}

}
