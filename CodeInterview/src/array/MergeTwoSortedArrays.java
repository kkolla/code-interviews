package array;

import utils.PrintUtils;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold 
 * additional elements from nums2. 
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 *
 */
public class MergeTwoSortedArrays {
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (k >= 0) {
			if (j < 0 || i >= 0 && nums1[i] > nums2[j])
				nums1[k] = nums1[i--];
			else
				nums1[k] = nums2[j--];
			k--;
		}
	}
	
	// more stupid
	public static void merge2(int[] nums1, int m, int[] nums2, int n) {
		// move the elements in nums1 to the end if m != 0
		int newStart1 = nums1.length - m;
		for (int i = nums1.length - 1; i >= newStart1; i--)
			nums1[i] = nums1[m - (nums1.length - i)];
		int start2 = 0, i = 0;
		while (newStart1 < nums1.length && start2 < nums2.length) {
			if (nums1[newStart1] <= nums2[start2]) {
				nums1[i] = nums1[newStart1];
				newStart1++;
			} else {
				nums1[i] = nums2[start2];
				start2++;
			}
			i++;
		}
		while (newStart1 < nums1.length) nums1[i++] = nums1[newStart1++];
		while (start2 < nums2.length) nums1[i++] = nums2[start2++];
    }

	public static void main(String[] args) {
		int[] nums1 = { 1, 3, 5, 0, 0};
		int[] nums2 = { 2, 3 };
		merge(nums1, 3, nums2, 2);
		PrintUtils.printArray(nums1);
		
		int[] nums3 = { 0 };
		int[] nums4 = { 1 };
		merge(nums3, 0, nums4, 1);
		PrintUtils.printArray(nums3);
	}

}
