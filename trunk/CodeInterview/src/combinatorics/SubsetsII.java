package combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,2], a solution is:
 * 
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class SubsetsII {
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int len = 0; len <= nums.length; len++) { // why this loop?
			subsetsWithDup(nums, 0, len, new ArrayList<Integer>(), result);  
		}
    	return result;
    }

	private static void subsetsWithDup(int[] nums, int start, int requiredLen, List<Integer> temp, List<List<Integer>> result) {
		if (requiredLen == temp.size()) {
			result.add(new ArrayList<Integer>(temp));
		} else {
			for (int i = start; i < nums.length; i++) {
				if (i > start && nums[i] == nums[i - 1]) continue;
				temp.add(nums[i]);
				subsetsWithDup(nums, i + 1, requiredLen, temp, result);
				temp.remove(temp.size() - 1);
			}
		}
	}
	
	public static void main(String[] s) {
		System.out.println(subsetsWithDup(new int[] {1, 2, 2}));
	}
}
