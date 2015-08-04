package array;

/**
 * Given an array of n integers where n > 1, nums, 
 * return an array output such that output[i] is equal to 
 * the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * Follow up:
 * Could you solve it with constant space complexity? 
 * (Note: The output array does not count as extra space for
 *  the purpose of space complexity analysis.)
 *
 */
public class ProductOfArrayExcludeSelf {
	
	public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        if (nums.length == 0) return result;
        
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        leftProduct[0] = 1;
        rightProduct[nums.length - 1] = 1;
        
        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = nums[i - 1] * leftProduct[i - 1];
            rightProduct[nums.length - i - 1] = nums[nums.length - i] * rightProduct[nums.length - i];
        }
        
        for (int i = 0; i < nums.length; i++)
            result[i] = leftProduct[i] * rightProduct[i];
        
        return result;
    }
	
	public int[] productExceptSelfImproved(int[] nums) {
        int[] result = new int[nums.length];
        if (nums.length == 0) return result;
        
        result[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = result[i + 1] * nums[i + 1];
        }
        
        int leftProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] *= leftProduct;
            leftProduct *= nums[i];
        }
        
        return result;
    }
}
