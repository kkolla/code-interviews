package combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.PrintUtils;

public class PrintAllSubsets {

	public static void allSubsetsIterative(int[] s) {
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

	public static void allSubsetsRecursive(int[] a, int start, String s) {
		if (start == a.length) {
			System.out.println(s);
		} else {
			allSubsetsRecursive(a, start + 1, s);
			allSubsetsRecursive(a, start + 1, s + a[start]);
		}
	}

	public static void allSubsetsWithoutDuplicates(int[] s) {
		Arrays.sort(s);
		allSubsetsWithoutDuplicates(s, 0, new ArrayList());
	}

	public static void allSubsetsWithoutDuplicates(int[] s, int start,
			List<Integer> l) {
		if (start == s.length) {
			PrintUtils.printList(l);
		} else {
			int count = 0;
			int i = start;
			while (i < s.length && s[start] == s[i]) {
				count++;
				i++;
			}
			l.add(s[start]);
			allSubsetsWithoutDuplicates(s, start + count, l);
			l.remove(l.size() - 1);
			allSubsetsWithoutDuplicates(s, start + count, l);
		}
	}

	public static void main(String[] args) {
		int[] set = new int[] { 1, 3, 2, 4, 1 };
		// allSubsetsIterative(set);
		allSubsetsRecursive(set, 0, "");
		// allSubsetsWithoutDuplicates(set);
	}
}
