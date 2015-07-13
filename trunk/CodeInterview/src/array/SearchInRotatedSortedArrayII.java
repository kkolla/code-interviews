package array;

/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 *
 */
public class SearchInRotatedSortedArrayII {

	// worst case: O(n)
	public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return true;
            if (nums[l] < nums[m]) {
                // left half is sosrted
                if (nums[l] <= target && target < nums[m]) r = m - 1;
                else l = m + 1;
            } else if (nums[l] > nums[m]) {
                // right half is sorted
                if (nums[m] < target && target <= nums[r]) l = m + 1;
                else r = m - 1;
            } else {
                // nums[l] == nums[m], we don't know which half is sorted
                l++;
            }
        }
        return false;
    }

}
