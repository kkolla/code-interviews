package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.PrintUtils;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 *
 */
public class FourSum {
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		return kSum(nums, 0, nums.length - 1, target, 4, new ArrayList<Integer>(), new ArrayList<List<Integer>>());
    }
	
	private static List<List<Integer>> kSum(int[] nums, int start, int end, int target, int k, List<Integer> solution, List<List<Integer>> solutions) {
		assert(k > 0);
		if (k == 1) {
			for (int i = start; i <= end; i++) {
				int num = nums[i];
				if (num == target) {
					solution.add(num);
					solutions.add(new ArrayList<Integer>(solution));
					solution.remove(solution.size() - 1);
				}
			}
		} else if (k == 2) {
			while (start < end) {
				int sum = nums[start] + nums[end];
				if (sum == target) {
					solution.add(nums[start]);
					solution.add(nums[end]);
					solutions.add(new ArrayList<Integer>(solution));
					solution.remove(solution.size() - 1);
					solution.remove(solution.size() - 1);
					// remove duplicate
					start++;
					end--;
					while (start <= end && nums[start] == nums[start - 1]) start++;
					while (start <= end && nums[end] == nums[end + 1]) end--;
				} else if (sum < target) {
					start++;
				} else {
					end--;
				}
			}
		} else {
			for (int i = start; i <= end; i++) {
				if (i > start && nums[i] == nums[i - 1]) continue;
				solution.add(nums[i]);
				kSum(nums, i + 1, end, target - nums[i], k - 1, solution, solutions);
				solution.remove(solution.size() - 1);
			}
		}
		return solutions;
	}

	public static void main(String[] args) {
		int[] nums = {1, 0, -1, 0, -2, 2};
		for (List<Integer> l : fourSum(nums, 0))
			PrintUtils.printList(l);
	}

}
