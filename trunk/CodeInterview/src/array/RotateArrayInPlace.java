package array;

/**
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 *
 */
public class RotateArrayInPlace {

    public static void reverse(int[] nums, int i, int j) {
        while (i <= j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }
    
    // time: O(n), space: O(1)
    public static void rotate(int[] nums, int k) {
    	if (k >= 0)
			k = k % nums.length;
		else
			k = (-(-k) % nums.length + nums.length) % nums.length;
        
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1); // if k == 0, this does nothing
        reverse(nums, k, nums.length - 1);
    }
    
    // rotate by one, for k times
    // time: O(kn), space: O(1)
    
    // use temporary array of size k
    // time: O(n), space: O(k)

	public static void main(String[] args) {
		int[] nums = { 1,2,3 };
		rotate(nums, 2);
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + " ");
	}

}
