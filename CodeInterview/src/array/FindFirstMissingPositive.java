package array;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class FindFirstMissingPositive {

	public static int firstMissingPositive(int[] nums) {
		if (nums.length == 0) return 1;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1 && nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i + 1) return i + 1;
        return i + 1;
	}

	public static void main(String[] args) {
		int[] a = CreateUtils.randIntArray(10, 10);
		PrintUtils.printArray(a);
		System.out.println(firstMissingPositive(a));
	}

}
