package dp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * Given a sequence of n real numbers A(1) ... A(n), 
 * determine a subsequence (not necessarily contiguous) 
 * of maximum length in which the values in the subsequence 
 * form a strictly increasing sequence.
 */
public class LongestIncreasingSequence {

	// s[i]: length of longest increasing sequence ending at a[i]
	// s[i] = max(s[j]) + 1 for all j<i and a[j]<a[i]
	// answer: max(s[i]) for all i
	// complexity: O(n^2), O(n)
	public static int lis(double[] a, List<Double> sequence) {
		Map<Integer, Integer> backtrack = new HashMap<Integer, Integer>();
		int[] s = new int[a.length];
		s[0] = 1;
		backtrack.put(0, -1);
		int max = 0;
		for (int i = 1; i < a.length; i++) {
			int m = Integer.MIN_VALUE, k = -1;
			for (int j = 0; j < i; j++)
				if (a[j] < a[i] && s[j] > m) {
					k = j;
					m = s[j];
				}
			if (k == -1) {
				s[i] = 1;
			} else {
				s[i] = m + 1;
			}
			backtrack.put(i, k);
			max = s[max] > s[i] ? max : i;
		}
		int t = max;
		do {
			sequence.add(0, a[t]);
			t = backtrack.get(t);
		} while (t != -1);
		return s[max];
	}

	public static void main(String[] args) {
		double[] a = CreateUtils.randRealArray(10);
		PrintUtils.printArray(a);
		List<Double> sequence = new LinkedList<Double>();
		System.out.println(lis(a, sequence));
		PrintUtils.printList(sequence);
	}

}
