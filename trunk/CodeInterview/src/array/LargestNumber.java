package array;

import utils.PrintUtils;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
	
	public static String largestNumber(int[] nums) {
		mergeSort(nums, 0, nums.length - 1);
		StringBuilder sb = new StringBuilder();
		for (int n : nums)
			sb.append(n);
		while (sb.length() > 1 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);
		return sb.toString();
    }
	
	private static void mergeSort(int[] nums, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			mergeSort(nums, start, mid);
			mergeSort(nums, mid + 1, end);
			merge(nums, start, mid, end);
		}
	}
	
	private static void merge(int[] nums, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];
		int leftStart = start, leftEnd = mid, rightStart = mid + 1;
		int i = 0;
		while (leftStart <= leftEnd && rightStart <= end) {
			if (bigger(nums[leftStart], nums[rightStart])) {
				temp[i++] = nums[leftStart++];
			} else {
				temp[i++] = nums[rightStart++];
			}
		}
		while (leftStart <= leftEnd) temp[i++] = nums[leftStart++];
		while (rightStart <= end) temp[i++] = nums[rightStart++];
		for (int j = 0; j < temp.length; j++) {
			nums[start + j] = temp[j];
		}
	}
	
	private static boolean bigger(int a, int b) {
		String s = a + "", t = b + "";
		return (t + s).compareTo(s + t) < 0;
	}

	public static void main(String[] args) {
		int[] nums = {3, 30, 34, 5, 9};
		System.out.println(largestNumber(nums));
	}

}
