package sorting;

import utils.PrintUtils;

/**
 * Partition an integers array into odd number first and even number second.
 * Example
 * Given [1, 2, 3, 4], return [1, 3, 2, 4]
 * Challenge
 * Do it in-place.
 *
 */
public class PartitionArrayByOddAndEven {
	public static void partitionArray(int[] nums) {
		int j = nums.length - 1;
        for (int i = 0; i < j;) {
            if (nums[i] % 2 == 1) {
                i++; // this number is put in the right place, go to the next one
            } else {
                swap(nums, i, j);
                j--;
            }
        }
    }
	
	public static void partitionArrayPreservingOrder(int[] nums) {
	  /* Initialize left and right indexes */
	  int left = 0, right = nums.length - 1;
	  while(left < right) {
	     /* Increment left index while we see 0 at left */
	     while(nums[left] % 2 == 1 && left < right) left++;
	 
	     /* Decrement right index while we see 1 at right */
	     while(nums[right] % 2 == 0 && left < right) right--;
	 
	     if(left < right) {
	       /* Swap arr[left] and arr[right]*/
	       swap(nums, left, right);
	       left++;
	       right--;
	     }
	  }
	}
    
    private static void swap(int[] nums, int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] s) {
    	int[] nums = { 0, 1, 3, 5, 7, 2, 9, 8, 4};
    	partitionArray(nums);
    	PrintUtils.printArray(nums);
    }
}
