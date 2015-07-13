package combinatorics;

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
		char[] s = new char[n];
		for (int i = 1; i <= n; i++)
			s[i - 1] = (char) ('0' + i);
		//for (int i = 1; i < k; i++)
			//NextPermutation.nextPermutation(s);
		return new String(s);
	}

	public static void main(String[] args) {
		for (int i = 1; i < 10; i++)
			System.out.println(getPermutation(5, i));
	}

}
