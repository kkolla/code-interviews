package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * company: Uber, stage: phone
 * 
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * 
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 *   [
 *     ["hit","hot","dot","dog","cog"],
 *     ["hit","hot","lot","log","cog"]
 *   ]
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 *
 */
public class WordLadderII {
	
	public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
		Queue<String> wordQueue = new LinkedList<String>();
		
		dict.add(end); // the end word needs to be present in dictionary
		wordQueue.add(start);
		
		Map<String, Set<String>> wordToNeighbors = constructWordToNeibhors(dict);
		System.out.println("wordToNeighbors: " + wordToNeighbors);
		
		// saves the word to previous transformations mappings
		Map<String, Set<String>> backtrack = new HashMap<String, Set<String>>();
		
		while (!wordQueue.isEmpty()) {
			// the queue contains all transformations in the previous one round
			// each transformation must exist in the dictionary
			
			// remove all transformations in the previous round
			// for each transformation, generate the next round of transformations and enqueue
			int numTransformations = wordQueue.size();
			Set<String> newWords = new HashSet<String>(); // only for optimization, can use wordQueue as well
			for (int i = 0; i < numTransformations; i++) {
				String word = wordQueue.poll();
				for (String neighbor : wordToNeighbors.get(word)) {
					if (dict.contains(neighbor)) { // the neighbor might have been removed from the dict
						wordQueue.add(neighbor);
						newWords.add(neighbor);
						Set<String> prevWords = backtrack.containsKey(neighbor) ?
							backtrack.get(neighbor) : new HashSet<String>();
						prevWords.add(word);
						backtrack.put(neighbor, prevWords);
					}
				}
			}
			dict.removeAll(newWords);
			
			// after transformations, if the end word appears, we can stop
			if (wordQueue.contains(end)) break;
		}
		
        System.out.println("backtrack: " + backtrack);
        
        List<String> temp = new ArrayList<String>();
        temp.add(end);
        
        return generateResult(start, end, backtrack, temp, new ArrayList<List<String>>());
    }
	
	private static Map<String, Set<String>> constructWordToNeibhors(Set<String> dict) {
		Map<String, Set<String>> wordToNeighbors = new HashMap<String, Set<String>>();
		for (String word : dict) {
			Set<String> neighbors = new HashSet<String>();
			for (int i = 0; i < word.length(); i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					if (word.charAt(i) == c) continue;
					String newWord = word.substring(0, i) + c + word.substring(i + 1);
					if (dict.contains(newWord)) {
						neighbors.add(newWord);
					}
				}
			}
			wordToNeighbors.put(word, neighbors);
		}
		return wordToNeighbors;
	}

	private static List<List<String>> generateResult(String start, String end, Map<String, Set<String>> backtrack, List<String> temp, List<List<String>> result) {
		if (end.equals(start)) {
			List<String> solution = new ArrayList<String>(temp);
			Collections.reverse(solution);
			result.add(solution);
		} else {
			Set<String> prevWords = backtrack.get(end);
			if (prevWords != null) {
				for (String prevWord : prevWords) {
					temp.add(prevWord);
					generateResult(start, prevWord, backtrack, temp, result);
					temp.remove(prevWord);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("hot"); dict.add("dot");
		dict.add("dog"); dict.add("lot"); dict.add("log");
		
		System.out.println(findLadders("hot", "cog", dict));
	}

}
