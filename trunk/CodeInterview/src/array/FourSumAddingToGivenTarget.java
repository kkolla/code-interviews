package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import utils.CreateUtils;
import utils.PrintUtils;
import datastructure.Pair;

/*
 * Given an array S of n integers, are there elements a, b, c, and d 
 * in S such that a + b + c + d = target? Find all unique quadruplets 
 * in the array which gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. 
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 */

// buggy! see http://basicalgos.blogspot.com/2012/03/12-4sum_11.html
public class FourSumAddingToGivenTarget {

	public static ArrayList<ArrayList<Integer>> findQuadruplets(int[] a,
			int target) {
		ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
		int n = a.length;
		if (n < 4)
			return l;
		Arrays.sort(a);
		PrintUtils.printArray(a);
		// pair(sum,pair(i,j))
		ArrayList<Pair<Integer, Pair<Integer, Integer>>> twoSums = new ArrayList<Pair<Integer, Pair<Integer, Integer>>>();
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				twoSums.add(new Pair<Integer, Pair<Integer, Integer>>(a[i]
						+ a[j], new Pair<Integer, Integer>(i, j)));
		Collections.sort(twoSums);
		// System.out.println("size:" + twoSums.size());
		for (int i = 0; i < twoSums.size() - 1; i++) {
			Pair<Integer, Pair<Integer, Integer>> firstPair = twoSums.get(i);
			int low = i + 1, high = twoSums.size() - 1;

			while (low <= high) {
				int mid = low + (high - low) / 2;
				Pair<Integer, Pair<Integer, Integer>> secondPair = twoSums
						.get(mid);
				int fourSum = firstPair.first + secondPair.first;
				if (fourSum == target) {
					int i1 = firstPair.second.first;
					int i2 = firstPair.second.second;
					int i3 = secondPair.second.first;
					int i4 = secondPair.second.second;
					if (i1 != i3 && i1 != i4 && i2 != i3 && i2 != i4)
						System.out.println(a[i1] + " " + a[i2] + " " + a[i3]
								+ " " + a[i4]);
				} else if (fourSum < target)
					low = mid + 1;
				else
					high = mid - 1;

			}
		}
		return l;
	}

	public static void main(String[] args) {
		int[] a = CreateUtils.randNonNegIntArray(10, 10);
		int target = CreateUtils.randNonNegInt(30);
		System.out.println(target);
		findQuadruplets(a, target);
	}

}
