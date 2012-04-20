package array;

import java.util.Arrays;

import utils.CreateUtils;
import utils.PrintUtils;

public class ThreeNumbersAddingToGivenSum {

	public static void findTuples(int[] a, int sum) {
		if (a.length < 3)
			return;
		Arrays.sort(a);
		for (int first = 0; first < a.length - 2; first++) {
			int second = first + 1;
			int third = a.length - 1;
			while (second < third) {
				int key = sum - a[first];
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
		int sum = CreateUtils.randNonNegInt(20);
		PrintUtils.printArray(a);
		System.out.println(sum);
		findTuples(a, sum);
	}

}
