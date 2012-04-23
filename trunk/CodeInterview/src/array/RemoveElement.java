package array;

import java.util.Arrays;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {

	// O(nlog(n))
	public static int removeElement(int[] a, int elem) {
		if (a.length == 0)
			return 0;
		int length = 0;
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			if (a[i] != elem) {
				a[length++] = a[i];
			}
		}
		return length;
	}

	public static void main(String[] args) {
		int[] a = CreateUtils.randNonNegIntArray(10, 20);
		PrintUtils.printArray(a);
		System.out.println(removeElement(a, CreateUtils.randNonNegInt(10)));
	}

}
