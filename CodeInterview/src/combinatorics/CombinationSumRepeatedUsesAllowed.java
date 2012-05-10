package combinatorics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * Given a set of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, É ,ak) must be in non-descending order. 
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 */
public class CombinationSumRepeatedUsesAllowed {

	public static ArrayList<ArrayList<Integer>> combinationSum(
			int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> ls = new ArrayList<ArrayList<Integer>>();
		combinationSumRecursive(candidates, target, ls,
				new ArrayList<Integer>(), new HashSet<String>());
		return ls;
	}

	public static void combinationSumRecursive(int[] candidates, int target,
			ArrayList<ArrayList<Integer>> ls, ArrayList<Integer> l,
			HashSet<String> outputs) {
		if (target == 0) {
			ArrayList<Integer> l2 = (ArrayList<Integer>) l.clone();
			Collections.sort(l2);
			StringBuffer output = new StringBuffer("");
			for (Integer f : l2) {
				output.append(f + " ");
			}
			if (!outputs.contains(output.toString())) {
				outputs.add(output.toString());
				ls.add(l2);
			}
			return;
		}
		for (int i = 0; i < candidates.length; i++) {
			if (target >= candidates[i]) {
				l.add(candidates[i]);
				combinationSumRecursive(candidates, target - candidates[i], ls,
						l, outputs);
				l.remove(l.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] candidates = { 3, 5, 6, 6, 7, 8, 10 };
		int target = CreateUtils.randNonNegInt(40);
		System.out.println("target: " + target);
		ArrayList<ArrayList<Integer>> ls = combinationSum(candidates, target);
		for (ArrayList<Integer> l : ls)
			PrintUtils.printList(l);
	}

}