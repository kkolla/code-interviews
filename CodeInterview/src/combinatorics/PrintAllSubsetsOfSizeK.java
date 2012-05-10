package combinatorics;

public class PrintAllSubsetsOfSizeK {

	public static void allSubsetsOfSizeKIterative(int[] s, int k) {
		int subsets = 1 << s.length;// number of subsets
		for (int i = 1; i <= subsets; i++) {
			int n = i; // use each bit in n to determine whether to print the
			int ones = 0;
			while (n > 0) {
				if ((n & 1) == 1)
					ones++;
				n >>= 1;
			}
			if (ones == k) {
				n = i;
				// corresponding number in s
				int shift = 0;
				while (shift < s.length) {
					// if the bit is 1, print
					boolean print = ((n >> shift) & 1) == 1;
					if (print)
						System.out.print(s[shift]);
					shift++;
				}
				System.out.println();
			}
		}
	}

	public static void allSubsetsOfSizeKRecursive(int[] a, int start, int k,
			String s) {
		if (k == 0) {
			System.out.println(s);
			return;
		}
		if (start == a.length)
			return;
		allSubsetsOfSizeKRecursive(a, start + 1, k, s);
		allSubsetsOfSizeKRecursive(a, start + 1, k - 1, s + a[start]);
	}

	public static void main(String[] args) {
		int k = 2;
		int[] set = new int[] { 1, 2, 3, 4, 5, 6 };
		// allSubsetsOfSizeKIterative(set, k);
		allSubsetsOfSizeKRecursive(set, 0, k, "");
	}

}
