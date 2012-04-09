package combinatorics;

public class PrintAllSubsets {

	public static void allSubsetsIterative(char[] s) {
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

	public static void allSubsetsRecursive(char[] s, int start, StringBuffer sb) {
		if (start == s.length) {
			System.out.println(sb.toString());
		} else {
			sb.append(s[start] + " ");
			allSubsetsRecursive(s, start + 1, sb);
			sb.setLength(sb.length() - 2);
			allSubsetsRecursive(s, start + 1, sb);
		}
	}

	public static void main(String[] args) {
		char[] set = new char[] { 'a', 'b', 'c', 'd', 'e' };
		allSubsetsIterative(set);
		allSubsetsRecursive(set, 0, new StringBuffer());
	}
}
