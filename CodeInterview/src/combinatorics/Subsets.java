package combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0, new ArrayList<Integer>(), new ArrayList<List<Integer>>());    
    }
    
    private List<List<Integer>> subsets(int[] nums, int start, List<Integer> temp, List<List<Integer>> result) {
        if (start == nums.length) {
            result.add(new ArrayList<Integer>(temp));
            Collections.sort(result.get(result.size() - 1));
        } else {
            subsets(nums, start + 1, temp, result);
            temp.add(nums[start]);
            subsets(nums, start + 1, temp, result);
            temp.remove(temp.size() - 1);
        }  
        return result;
    }
    
    public List<List<Integer>> subsetsIterative(int[] nums) {
    	List<List<Integer>> subsets = new ArrayList<List<Integer>>();
    	// empty subset
    	subsets.add(new ArrayList<Integer>());
    	
    	Arrays.sort(nums);
    	for (int num : nums) {
    		List<List<Integer>> subsetsForCurrNum = new ArrayList<List<Integer>>();
    		// add the current number to each subset generated before
    		for (List<Integer> subset : subsets) {
    			List<Integer> subsetCopy = new ArrayList<Integer>(subset);
    			subsetCopy.add(num);
    			subsetsForCurrNum.add(subsetCopy);
    		}
    		subsets.addAll(subsetsForCurrNum);
    	}
    	
    	return subsets;
    }
}
