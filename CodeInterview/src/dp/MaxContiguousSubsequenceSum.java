package dp;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * Given a sequence of n real numbers A(1) ... A(n), 
 * determine a contiguous subsequence A(i) ... A(j) 
 * for which the sum of elements in the subsequence is maximized.
 */
public class MaxContiguousSubsequenceSum {

	// s[i]: the max sum ending at a[i]
	// s[i] = max(s[i-1] + a[i], a[i])
	// answer: max(s[i]) for all i
	// complexity: O(n), O(n)
	public static double maxSubsequenceSum(double[] a) {
		double[] s = new double[a.length];
		double max = s[0] = a[0];
		for (int i = 1; i < a.length; i++) {
			s[i] = s[i - 1] < 0 ? a[i] : s[i - 1] + a[i];
			max = Math.max(max, s[i]);
		}
		return max;
	}

	// complexity: O(n), O(1)
	public static double maxSubsequenceSumConstSpace(double[] a) {
		double sum = a[0];
		double max = a[0];
		for (int i = 1; i < a.length; i++) {
			sum = Math.max(a[i], sum + a[i]);
			max = Math.max(max, sum);
		}
		return max;
	}

	public static void main(String[] args) {
		double[] a = CreateUtils.randRealArray(10, 10);
		PrintUtils.printArray(a);
		System.out.println(maxSubsequenceSum(a));
		System.out.println(maxSubsequenceSumConstSpace(a));
	}

}
