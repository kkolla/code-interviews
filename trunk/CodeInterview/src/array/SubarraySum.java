package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
	public ArrayList<Integer> subarraySum(int[] nums) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int sum = 0;
		Map<Integer, Integer> sumToEndIndex = new HashMap<Integer, Integer>();
		sumToEndIndex.put(sum, -1); // key

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sumToEndIndex.containsKey(sum)) {
				result.add(sumToEndIndex.get(sum) + 1);
				result.add(i);
				break;
			}
			sumToEndIndex.put(sum, i);
		}
		
		return result;
    }
}
