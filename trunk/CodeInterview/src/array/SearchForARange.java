package array;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 *
 */
public class SearchForARange {
	public int[] searchRange(int[] nums, int target) {
        int l = search(nums, target, true);
        if (l == -1) return new int[] { -1, -1 };
        int r = search(nums, target, false);
        return new int[] { l, r };
    }
    
    private int search(int[] nums, int target, boolean searchLeftmost) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target &&
                (searchLeftmost && (m == 0 || nums[m] != nums[m - 1]) || 
                !searchLeftmost && (m == nums.length - 1 || nums[m] != nums[m + 1]))) {
                return m;
            } else if (searchLeftmost) {
                if (nums[m] < target) l = m + 1;
                else r = m - 1;
            } else {
                if (nums[m] > target) r = m - 1;
                else l = m + 1;
            }
        }
        return -1;
    }
}
