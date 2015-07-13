package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 *
 */
public class GroupAnagrams {
	// O(numStrs * maxLen * log(maxLen))
	public List<String> anagrams(String[] strs) {
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < strs.length; i++) {
            char[] cs = strs[i].toCharArray();
            Arrays.sort(cs);
            String str = new String(cs);
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<Integer>());  
            }
            map.get(str).add(i);
        }
        List<String> result = new ArrayList<String>();
        for (List<Integer> l : map.values()) {
            if (l.size() > 1)
                for (int i : l) result.add(strs[i]);
        }
        return result;
    }
}
