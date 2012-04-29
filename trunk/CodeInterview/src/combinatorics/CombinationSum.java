package combinatorics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … ,ak) must be in non-descending order.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 */
public class CombinationSum {

	public static ArrayList<ArrayList<Integer>> combinationSum(
			int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> ls = new ArrayList<ArrayList<Integer>>();
		combinationSumRecursive(candidates, 0, target, ls,
				new ArrayList<Integer>(), new HashSet<String>(),
				new boolean[candidates.length]);
		return ls;
	}

	public static void combinationSumRecursive(int[] candidates, int target,
			ArrayList<ArrayList<Integer>> ls, ArrayList<Integer> l,
			HashSet<String> outputs, boolean[] used) {
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
			if (!used[i] && target >= candidates[i]) {
				used[i] = true;
				l.add(candidates[i]);
				combinationSumRecursive(candidates, target - candidates[i], ls,
						l, outputs, used);
				l.remove(l.size() - 1);
				used[i] = false;
			}
		}
	}

	public static void combinationSumRecursive(int[] candidates, int start,
			int target, ArrayList<ArrayList<Integer>> ls, ArrayList<Integer> l,
			HashSet<String> outputs, boolean[] used) {
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
		if (start == candidates.length)
			return;
		l.add(candidates[start]);
		combinationSumRecursive(candidates, start + 1, target
				- candidates[start], ls, l, outputs, used);
		l.remove(l.size() - 1);
		combinationSumRecursive(candidates, start + 1, target, ls, l, outputs,
				used);
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
