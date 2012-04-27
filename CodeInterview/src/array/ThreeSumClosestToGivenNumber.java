package array;

import java.util.Arrays;

/*
 * Given an array S of n integers, find three integers in S 
 * such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosestToGivenNumber {
	public static int threeSumClosest(int[] a, int target) {
		Arrays.sort(a);
		int closestSum = a[0] + a[1] + a[2];
		int minAbs = Math.abs(target - closestSum);
		for (int i = 0; i < a.length - 2; i++) {
			int j = i + 1;
			int k = a.length - 1;
			while (j < k) {
				int sum = a[i] + a[j] + a[k];
				if (Math.abs(sum - target) < minAbs) {
					minAbs = Math.abs(sum - target);
					closestSum = sum;
				}
				if (sum == target) {
					break;
				} else if (sum > target)
					k--;
				else
					j++;
			}
		}
		return closestSum;
	}
}
