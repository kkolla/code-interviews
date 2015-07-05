package dp;

import utils.CreateUtils;
import utils.PrintUtils;

public class HouseRobberII {
	
	public static int rob(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		
		int odd1 = 0, even1 = 0;
		for (int i = 1; i < nums.length; i++)
			if (i % 2 != 0)
				odd1 = Math.max(odd1 + nums[i], even1);
			else
				even1 = Math.max(even1 + nums[i], odd1);
		
		int odd2 = 0, even2 = 0;
		for (int i = 0; i < nums.length - 1; i++)
			if (i % 2 == 0)
				odd2 = Math.max(odd2 + nums[i], even2);
			else
				even2 = Math.max(even2 + nums[i], odd2);
		
		return Math.max(Math.max(Math.max(odd1, even1), odd2), even2);
    }

	public static void main(String[] args) {
		int[] nums = CreateUtils.randNonNegIntArray(5, 10);
		PrintUtils.printArray(nums);
		System.out.println(rob(nums));
	}

}
