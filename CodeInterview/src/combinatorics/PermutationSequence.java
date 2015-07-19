package combinatorics;

import java.util.ArrayList;
import java.util.List;

import utils.PrintUtils;

/*
 * The set [1,2,3,�,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 */
public class PermutationSequence {
	
	public static String getPermutation(int n, int k) {
		int[] factorials = new int[n + 1];
		factorials[0] = 1;
		for (int i = 1; i < factorials.length; i++)
			factorials[i] = i * factorials[i - 1];

		List<Character> nums = new ArrayList<Character>();
		for (int i = 1; i <= n; i++)
			nums.add((char) (i + '0'));

		k = (k - 1) % factorials[n]; // - 1 to make it consistent with the array/list index
		String s = "";
		for (int i = n; i >= 1; i--) {
			// to determine the current digit, there are (n - 1)! numbers starting with each digit
			// so k / (n - 1)! is the index of the digit
			int numIndex = k / factorials[i - 1]; 
			s += nums.get(numIndex);
			nums.remove(numIndex);
			// before going to the next iteration, we need to decrease k to reflect the fact that
			// the subsequence to be considered will be one less in length
			k = k % factorials[i - 1];
		}
		return s;
    }

	public static String getPermutation2(int n, int k) {
		char[] s = new char[n];
		for (int i = 1; i <= n; i++)
			s[i - 1] = (char) ('0' + i);
		//for (int i = 1; i < k; i++)
		//	NextPermutation.nextPermutation(s);
		return new String(s);
	}

	public static void main(String[] args) {
		for (int i = 1; i < 30; i++) {
			System.out.print(i + "th permutation for n = 5: ");
			System.out.println(getPermutation(5, i));
		}
	}

}
