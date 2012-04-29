package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import utils.CreateUtils;
import utils.PrintUtils;

public class ThreeSumAddingToGivenTarget {

	// O(n), O(n)
	public static void findPairsByHash(int[] a, int target) {
		if (a.length < 2)
			return;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < a.length; i++)
			if (set.contains(target - a[i]))
				System.out.println(a[i] + " " + (target - a[i]));
			else
				set.add(a[i]);
	}

	// O(nlog(n)), O(1)
	public static void findPairsBySort(int[] a, int target) {
		if (a.length < 2)
			return;
		Arrays.sort(a);
		for (int left = 0, right = a.length - 1; left < right;)
			if (a[left] + a[right] == target)
				System.out.println(a[left++] + " " + a[right]);
			else if (a[left] + a[right] < target)
				left++;
			else
				right--;
	}

	public static void main(String[] args) {
		int[] a = CreateUtils.randIntArray(10, 10);
		int target = CreateUtils.randInt(15);
		PrintUtils.printArray(a);
		System.out.println(target);
		findPairsByHash(a, target);
		findPairsBySort(a, target);
	}

}
