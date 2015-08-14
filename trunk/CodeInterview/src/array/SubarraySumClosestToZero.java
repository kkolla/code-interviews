package array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an integer array, find a subarray with sum closest to zero. 
 * Return the indexes of the first number and last number.
 * 
 * Example
 * Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4]
 * Challenge
 * O(nlogn) time
 *
 */
public class SubarraySumClosestToZero {
	
	private static class Pair implements Comparable<Pair> {

		@Override
		public int compareTo(Pair p) {
			return value - p.value;
		}

		int value;
		int index;
		
		public Pair(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
	
	public ArrayList<Integer> subarraySumClosest(int[] nums) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		 // subarraySums[i]: sum from num[0] to num[i];
		Pair[] subarraySums = new Pair[nums.length + 1];
		
		int sum = 0;
		subarraySums[0] = new Pair(sum, -1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			subarraySums[i + 1] = new Pair(sum, i);
		}
		
		// now sum(nums[i]...nums[j]) can be computed by subarraySums[j] - subarraySum[i - 1];
		// find min subarray sum would take O(n^2) if we enumerate pairs
		
		// after sorting subarraySums, the min subarray sum must be adjacent difference
		Arrays.sort(subarraySums);
		
		int startIndex = Math.min(subarraySums[0].index, subarraySums[1].index) + 1;
		int endIndex = Math.max(subarraySums[0].index, subarraySums[1].index);
		int minDifference = Math.abs(subarraySums[0].value - subarraySums[1].value);
		for (int i = 1; i < subarraySums.length; i++) {
			int difference = Math.abs(subarraySums[i].value - subarraySums[i - 1].value);
			if (difference < minDifference) {
				minDifference = difference;
				startIndex = Math.min(subarraySums[i].index, subarraySums[i - 1].index) + 1;
				endIndex = Math.max(subarraySums[i].index, subarraySums[i - 1].index);
			}
		}
		
		result.add(startIndex);
		result.add(endIndex);
		return result;
    }
}
