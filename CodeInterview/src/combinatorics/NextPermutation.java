package combinatorics;

import utils.PrintUtils;

/*
 * http://wordaligned.org/articles/next-permutation#tocwhats-happening-here
 */
public class NextPermutation {

	public static void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        
        int pivot = nums.length - 2; 
        // from right to left, find the first element such that nums[pivot] < nums[pivot + 1]
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1])
            pivot--;
            
        if (pivot != -1) {
            int t = nums.length - 1; 
            // from right to left, find the first element larger than the pivot
            while (t >= 0 && nums[t] <= nums[pivot])
                t--;
            // swap it with the pivot to get a larger head
            swap(nums, pivot, t);    
        }
            
        // reverse the right partition to get a smaller tail
        int start = pivot + 1, end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp; 
    }

	public static void main(String[] args) {
		int[] nums = {3, 4, 1, 1, 5, 2};
		for (int i = 0; i < 5; i++) {
			PrintUtils.printArray(nums);
			nextPermutation(nums);
		}
	}

}
