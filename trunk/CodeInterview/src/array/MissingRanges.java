package array;

import java.util.ArrayList;
import java.util.List;

import utils.PrintUtils;

/**
 * Given a sorted integer array where the range of elements are [0, 99] inclusive, 
 * return its missing ranges.
 * For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]
 *
 */
public class MissingRanges {
	
	public static List<String> missing(int[] nums, int lower, int upper) {
		List<String> ranges = new ArrayList<String>();
		int start = lower - 1;
		for (int i = 0; i < nums.length + 1; i++) {
			int end = i == nums.length ? upper + 1 : nums[i];
			if (end - start == 2) {
				ranges.add(start + 1 + "");
			} else if (end - start > 2) {
				ranges.add((start + 1) + "->" + (end - 1));
			}
			start = end;
		}
		return ranges;
	}

	public static void main(String[] args) {
		PrintUtils.printList(missing(new int[] {0, 1, 3, 50, 75}, 1, 99));
		PrintUtils.printList(missing(new int[] {33, 45, 50, 75, 98}, 1, 99));
	}

}
