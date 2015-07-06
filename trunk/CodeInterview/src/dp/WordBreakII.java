package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, 
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 *
 */
public class WordBreakII {

	public static List<String> wordBreakRecursive(String s, Set<String> wordDict) {
        return wordBreakRecursive(s, wordDict, "", new ArrayList<String>());    
    }
    
    private static List<String> wordBreakRecursive(String s, Set<String> wordDict, String temp, List<String> result) {
        if (s.isEmpty()) {
            if (!temp.isEmpty()) result.add(temp);
            return result;
        }
        
        for (int i = 0; i < s.length(); i++) {
            String word = s.substring(0, i + 1);
            if (wordDict.contains(word)) {
                wordBreakRecursive(s.substring(i + 1), wordDict, temp.isEmpty() ? word : temp + " " + word, result);
            }
        }
        
        return result;
    }
    
    public List<String> wordBreak(String s, Set<String> dict) {
	      // canBeBroken[i] = true, if for any j < i, canBeBroken[j] is true and s.substring(j, i + 1) is a word
	      boolean[] canBeBroken = new boolean[s.length() + 1]; 
	      canBeBroken[0] = true;
	      
	      Map<Integer, List<Integer>> backtrack = new HashMap<Integer, List<Integer>>();
	      
	      for (int i = 0; i < canBeBroken.length; i++) {
	        for (int j = 0; j < i; j++) {
	            if (canBeBroken[j]) {
	                if (dict.contains(s.substring(j, i))) {
	                    canBeBroken[i] = true;
	                    
	                    if (!backtrack.containsKey(i)) {
	                        backtrack.put(i, new ArrayList<Integer>());
	                    }
	                    List<Integer> l = backtrack.get(i);
	                    l.add(j);
	                    backtrack.put(i, l);
	                }
	            }
	        }
	      }

	      List<String> result = new ArrayList<String>();
	      generateResult(s, backtrack, s.length(), result, "");
	      
	      return result;
    }
	
	private void generateResult(String s, Map<Integer, List<Integer>> backtrack, int end, List<String> result, String temp) {
		List<Integer> l = backtrack.get(end);
		if (l == null) {
			if (!temp.isEmpty()) result.add(temp);
			return;
		}
		
		for (int start : l) {
			String word = s.substring(start, end);
			generateResult(s, backtrack, start, result, temp.isEmpty() ? word : word + " " + temp);
		}
	}
    
	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("cat");dict.add("cats");dict.add("and");dict.add("sand");dict.add("dog");
		String s = "catsanddog";
		List<String> result = wordBreakRecursive(s, dict);
		System.out.println(result.size());
		for (String t : result)
			System.out.println(t);
	}

}
