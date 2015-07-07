package combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, � ,ak) must be in non-descending order.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 */
public class CombinationSum {

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum(candidates, target, 0, new ArrayList<Integer>(), new ArrayList<List<Integer>>());    
    }
    
    public static List<List<Integer>> combinationSum(int[] candidates, int target, int start, List<Integer> temp, List<List<Integer>> result) {
        if (start == candidates.length || target <= 0) {
            if (target == 0) result.add(new ArrayList<Integer>(temp));
            return result;
        }   
        
        temp.add(candidates[start]);
        combinationSum(candidates, target - candidates[start], start, temp, result);
        temp.remove(temp.size() - 1);
        combinationSum(candidates, target, start + 1, temp, result);
        
        return result;
    }
    
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum2(candidates, target, 0, new ArrayList<Integer>(), new ArrayList<List<Integer>>());    
    }
    
    public static List<List<Integer>> combinationSum2(int[] candidates, int target, int start, List<Integer> temp, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(temp));
            return result;
        }   
        
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            
            if (target >= candidates[i]) {
                temp.add(candidates[i]);
                combinationSum2(candidates, target - candidates[i], i + 1, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
        
        return result;
    }
    
    public static List<List<Integer>> combinationSum3(int k, int n) {
    	return combinationSum3(k, n, 1, 0, new ArrayList<Integer>(), new ArrayList<List<Integer>>());
    }
    
    public static List<List<Integer>> combinationSum3(int k, int n, int start, int sum, List<Integer> temp, List<List<Integer>> result) {
    	if (k == 0) {
    		if (sum == n) {
    			result.add(new ArrayList<Integer>(temp));
    		}
    		return result;
    	}
    	
    	for (int i = start; i <= 9; i++) {
    		if (sum + i <= n) {
    			temp.add(i);
    			combinationSum3(k - 1, n, i + 1, sum + i, temp, result);
    			temp.remove(temp.size() - 1);
    		}
    	}
    	return result;
    }

	public static void main(String[] args) {
		int[] candidates = { 3, 5, 6, 7, 8, 10 };
		int target = CreateUtils.randNonNegInt(40);
		System.out.println("target: " + target);
		List<List<Integer>> ls = combinationSum(candidates, target);
		for (List<Integer> l : ls)
			PrintUtils.printList(l);
		
		int k = 3, n = 9;
		System.out.println("k: " + k + ", n = " + n);
		List<List<Integer>> ls3 = combinationSum3(k, n);
		for (List<Integer> l : ls3)
			PrintUtils.printList(l);

	}

}
