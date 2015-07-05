package dp;

import utils.CreateUtils;
import utils.PrintUtils;

/**
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them is that 
 * adjacent houses have security system connected and 
 * it will automatically contact the police 
 * if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 *
 */
public class HouseRobber {
	
	// money[i]: max amount of money to rob for nums[0]...nums[i]
	// answer: money[nums.length - 1]
	// money[i] = the larger of
	//		money[i - 1] -- not robbing nums[i]
	//		money[i - 2] + nums[i] -- robbing nums[i], so cannot rob nums[i - 1]
	// init: money[0] = nums[0], money[1] = max(nums[0], nums[1])
	public static int rob(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
        
		int[] money = new int[nums.length];
		
		money[0] = nums[0];
		if (nums.length > 1) money[1] = Math.max(nums[0], nums[1]);
		
		for (int i = 2; i < nums.length; i++) {
			money[i] = Math.max(money[i - 1], money[i - 2] + nums[i]);
		}
		return money[nums.length - 1];
    }
	
	// space: O(1)
	public static int rob2(int[] nums) {
		int odd = 0, even = 0;
		for (int i = 0; i < nums.length; i++)
			if (i % 2 == 0) // odd index
				odd = Math.max(odd + nums[i], even);
			else
				even = Math.max(even + nums[i], odd);
		return Math.max(odd, even);
	}

	public static void main(String[] args) {
		int[] nums = CreateUtils.randNonNegIntArray(5, 10);
		PrintUtils.printArray(nums);
		System.out.println(rob(nums));
	}

}
