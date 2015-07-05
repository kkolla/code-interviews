package recursion;


/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 *
 * definition of the Median:
 * If the size of the sequence N is odd: N/2+1th element is median.
 * If the size of the sequence N is even: average of the N/2th and N/2+1th element is median.
 */
public class FindMedianOfTwoSortedArray {
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int totalLen = nums1.length + nums2.length;
		if (totalLen % 2 != 0)
			return FindKthSmallestInTwoArrays.findKthSmallest(nums1, nums2, 0, 0, totalLen / 2 + 1);
		else {
			int m1 = FindKthSmallestInTwoArrays.findKthSmallest(nums1, nums2, 0, 0, totalLen / 2);
			int m2 = FindKthSmallestInTwoArrays.findKthSmallest(nums1, nums2, 0, 0, totalLen / 2 + 1);
			return (m1 + m2) / 2.0;
		}
    }

	public static void main(String[] args) {
		int[] nums1 = {1,3,5,7,9};
		int[] nums2 = {2,4,8,10,12,14,16,18};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

}
