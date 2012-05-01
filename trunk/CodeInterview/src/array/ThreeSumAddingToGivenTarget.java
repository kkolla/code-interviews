package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import utils.CreateUtils;
import utils.PrintUtils;

public class ThreeSumAddingToGivenTarget {

	public static void findTuples(int[] a, int target) {
		if (a.length < 3)
			return;
		Arrays.sort(a);
		for (int first = 0; first < a.length - 2; first++) {
			int second = first + 1;
			int third = a.length - 1;
			while (second < third) {
				int key = target - a[first];
				if (key == a[second] + a[third]) {
					System.out.println(a[first] + " " + a[second] + " "
							+ a[third]);
					third--;
					second++;
				} else if (key < a[second] + a[third]) {
					third--;
				} else {
					second++;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a = CreateUtils.randNonNegIntArray(10, 10);
		int target = CreateUtils.randNonNegInt(20);
		PrintUtils.printArray(a);
		System.out.println(target);
		findTuples(a, target);
	}
}
