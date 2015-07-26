package array;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 *
 */
public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m > 0 && nums[m] < nums[m - 1]) return nums[m]; // if rotated, the pivot will always be found here
            else if (nums[m] > nums[r]) l = m + 1;
            else r = m - 1;
        }
        assert(l == 0);
        return nums[0]; // if not rotated, the first element is the min
    }
	
	public int findMin2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[r]) r = m; // the right half is sorted, and we don't know if mid is the smallest
            else l = m + 1; // the smallest must be on the right half
        }
        return nums[l];
    }

    public int findMinRecursive(int[] nums) {
        return findMinRecursive(nums, 0, nums.length - 1);    
    }
    
    public int findMinRecursive(int[] nums, int l, int r) {
        if (l > r) return nums[0]; // not rotated
        if (l == r) return nums[l];
        
        int m = l + (r - l) / 2;
        if (m > 0 && nums[m] < nums[m - 1]) return nums[m];
        else if (nums[m] > nums[r]) return findMinRecursive(nums, m + 1, r);
        else return findMinRecursive(nums, l, m - 1);
    }
}
