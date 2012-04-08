package combinatorics;

public class PrintAllSubsets {

	public static void allSubsets(char[] s) {
		int k = 1 << s.length;// number of subsets
		for (int i = 1; i <= k; i++) {
			int n = i; // use each bit in n to determine whether to print the
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

	public static void main(String[] args) {
		allSubsets(new char[] { 'a', 'b', 'c', 'd', 'e' });
	}

}
