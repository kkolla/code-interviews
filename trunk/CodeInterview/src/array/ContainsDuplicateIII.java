package array;

import java.util.TreeSet;

import utils.CreateUtils;

/**
 * Given an array of integers, find out whether there are two distinct 
 * indices i and j in the array such that the difference between nums[i] and nums[j] 
 * is at most t and the difference between i and j is at most k.
 *
 */
public class ContainsDuplicateIII {
	
	// O(nlog(k))
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;	// hmm

		TreeSet<Long> set = new TreeSet<Long>();
		for (int i = 0; i < nums.length; i++) {
			long lowerBound = (long) nums[i] - t;
			long upperBound = (long) nums[i] + t + 1;
			if (!set.subSet(lowerBound, upperBound).isEmpty()) return true;
			set.add((long) nums[i]);
			if (set.size() > k) {
				set.remove((long) nums[i - k]);
			}
		}
		return false;
    }

	public static void main(String[] args) {
		int[] nums = {1, 3, 10, 5, 6};
		int k = CreateUtils.randNonNegInt(7);
		int t = CreateUtils.randNonNegInt(8);
		System.out.println("k = " + k + ", t = " + t);
		System.out.println(containsNearbyAlmostDuplicate(nums, k, t ));
	}

}
