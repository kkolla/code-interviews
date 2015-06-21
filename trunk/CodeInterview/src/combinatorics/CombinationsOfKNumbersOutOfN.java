package combinatorics;

import java.util.ArrayList;
import java.util.List;

import utils.PrintUtils;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * For example,
 * If n = 4 and k = 2, a solution is:
 *
 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 * ]
 */
public class CombinationsOfKNumbersOutOfN {
	
	public static List<List<Integer>> combine(int n, int k) {
        return combine(n, k, 1, new ArrayList<List<Integer>>(), new ArrayList<Integer>());
    }
	
	public static List<List<Integer>> combine(int n, int k, int p, List<List<Integer>> result, List<Integer> temp) {
		if (k == temp.size()) {
			result.add(new ArrayList<Integer>(temp));
			return result;
		}
		
		for (int i = p; i <= n; i++) {
			temp.add(i);
			combine(n, k, i + 1, result, temp);
			temp.remove(temp.size() - 1);
		}
		
		return result;
	}
	
	public static List<List<Integer>> combine2(int n, int k, int i, List<List<Integer>> result, List<Integer> temp) {
		if (i > n) {
			if (k == temp.size()) result.add(new ArrayList<Integer>(temp));
			return result;
		}
		
		// not selecting the current number
		combine(n, k, i + 1, result, temp);
		// selecting the current number;
		temp.add(i);
		combine(n, k, i + 1, result, temp);
		temp.remove(temp.size() - 1);
		
		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> result = combine(5, 3);
		for (List<Integer> l : result)
			PrintUtils.printList(l);
	}

}
