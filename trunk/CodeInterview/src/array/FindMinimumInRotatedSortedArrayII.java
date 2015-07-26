package array;

public class FindMinimumInRotatedSortedArrayII {
	public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) l = m + 1; // the smallest must be on the right half
            else if (nums[m] == nums[r]) r = r - 1; // unsure which half has the smallest (this may degrade the algorithm to O(n))
            else r = m; // nums[m] < nums[r], the smallet must be on the left half or the mid
        }
        return nums[l];
    }
}
