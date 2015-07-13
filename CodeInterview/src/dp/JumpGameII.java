package dp;

/**
 * Given an array of non-negative integers, 
 * you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. 
 * (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 *
 */
public class JumpGameII {
	
	public static int jumpGreedy(int[] nums) {
        if (nums.length <= 1) return 0;

		int start = 0, end = 0;
		int steps = 0, max;
		
		while (end < nums.length) {
			steps++;
			max = 0;
			for (int i = start; i <= end; i++) {
				int reach = i + nums[i];
				if (reach >= nums.length - 1) return steps;
				max = Math.max(max, reach);
			}
			start = end + 1;
			end = max;
		}
		
		return steps;
	}
	
	// jumps[i]: minimum jumps to the last index from i - 1
	// answer: jumps[0]
	// init: jumps[nums.length - 1] = 0
	// jumps[i] = min(jumps[j]) + 1 for all len > j > i and nums[i] >= j - i
	// O(n^2) TLE
	public static int jumpDP(int[] nums) {
		if (nums.length <= 1) return nums.length;
		
		int[] jumps = new int[nums.length];
		for (int i = nums.length - 2; i >= 0; i--) {
			int minJumps = Integer.MAX_VALUE;
			for (int j = i + 1; nums[i] >= j - i && j < nums.length; j++) {
				minJumps = Math.min(jumps[j], minJumps);
			}
			jumps[i] = minJumps + 1; // wrong if cannot jump
		}
		
		return jumps[0];
    }

	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		System.out.println(jumpGreedy(nums));
		System.out.println(jumpDP(nums));
	}

}
