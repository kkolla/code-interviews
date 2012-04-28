package dp;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class JumpGame {

	public static boolean canJump(int[] a) {
		if (a.length <= 1)
			return true;
		for (int i = 0, max = 0; i <= max; i++) {
			max = Math.max(max, i + a[i]);
			if (max >= a.length - 1)
				return true;
		}
		return false;
	}

	// s[i]: minimum number of steps to jump to here
	// s[i] = min(s[j])+1 for all j<i && a[j]>=i-j
	// base: s[0] = 0
	// answer: s[a.length-1]
	// cannot pass large input, might be a O(n) solution out there
	public static int jumpSteps(int[] a) {
		if (a.length <= 1)
			return 0;
		int[] s = new int[a.length];
		s[0] = 0;
		for (int i = 1; i < a.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++)
				if (a[j] >= i - j)
					min = Math.min(min, s[j]);
			s[i] = min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1;
		}
		return s[a.length - 1];
	}

	public static void main(String[] args) {
		System.out.println(jumpSteps(new int[] { 1, 2 }));
	}
}
