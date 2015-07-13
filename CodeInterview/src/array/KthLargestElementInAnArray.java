package array;

public class KthLargestElementInAnArray {
	
	public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);   
    }
    
    private int findKthLargest(int[] nums, int start, int end, int k) {
        // use the last element as pivot
        int pivot = nums[end];
        
        int left = start, right = end;
        while (true) {
            // find the first number greater than to equal to pivot from left to right
            while (nums[left] < pivot && left < right) left++;
            // find the first number smaller than pivot from right to left
            while (nums[right] >= pivot && left < right) right--;
            if (left == right) break; // numbers placed as expected, no need to swap
            swap(nums, left, right);
        }
        
        // place the pivot in the middle for correct partition
        swap(nums, left, end);
        
        if (left == nums.length - k) return pivot;
        else if (left > nums.length - k) return findKthLargest(nums, start, left - 1, k);
        else return findKthLargest(nums, left + 1, end, k);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
