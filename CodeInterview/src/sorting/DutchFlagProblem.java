package sorting;

import utils.PrintUtils;

/*Given  an integer array and a specific integer x, write a program to do a three-partition.
 That is, the left part of the array is less than x, the middle part is equal to x and
 the right part is bigger than x
 E.g     array: 0 1 2 1 2 1 2 0 0 2 1 0 0 2 2 1 0  ==>  0 0 0 0 0 0 1 1 1 1 1 2 2 2 2 2 2 
 */

public class DutchFlagProblem {

	public static void dutchFlagSort(int[] nums) {
        int i = 0, red = 0, blue = nums.length - 1;
        while (i <= blue) {
            if (nums[i] == 0) {
                // put the red to left
                swap(nums, i, red);
                // increase the red end index
                red++;
                // the current number is correctly set, go to the next one
                i++;
            } else if (nums[i] == 2) {
               // put the blue to right
               swap(nums, i, blue);
               // decrease the blue start index
               blue--;
               // the current element after swapping is not considered yet
            } else {
                // nothing to do when seeing a white, go to the next one
                i++;
            }
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void countingSort(int[] nums) {
        int[] counts = new int[3];
        for (int num : nums)
            counts[num]++;
        int index = 0;
        for (int i = 0; i < counts.length; i++)
            for (int j = 0; j < counts[i]; j++)
                nums[index++] = i;
    }

	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 1, 2, 1, 2, 0, 0, 2, 1, 0, 0, 2, 2, 1, 0 };
		PrintUtils.printArray(a);
		dutchFlagSort(a);
		PrintUtils.printArray(a);
		a = new int[] { 0, 1, 0, 0, 1, 0, 0, 1, 0 };
		dutchFlagSort(a);
		PrintUtils.printArray(a);
	}
}
