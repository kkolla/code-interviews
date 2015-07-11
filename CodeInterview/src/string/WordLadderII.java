package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
	
	public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
		Queue<String> wordQueue = new LinkedList<String>();
		Queue<Integer> distanceQueue = new LinkedList<Integer>();
		
		dict.add(end); // the end word doesn't need to be present in dictionary
		wordQueue.add(start);
		distanceQueue.add(1);
		
		Map<String, List<String>> backtrack = new HashMap<String, List<String>>();
		
		while (!wordQueue.isEmpty()) {
			String word = wordQueue.poll();
			int distance = distanceQueue.poll();
			
			if (word.equals(end)) break;
			
			for (int i = 0; i < start.length(); i++)
				for (char c = 'a'; c <= 'z'; c++) {
					if (word.charAt(i) == c) continue;
					String newWord = word.substring(0, i) + c + word.substring(i + 1);
					if (dict.contains(newWord)) {
						wordQueue.add(newWord);
						distanceQueue.add(distance + 1);
						dict.remove(newWord);
						List<String> prevWords = backtrack.containsKey(newWord) ? backtrack.get(newWord) : new ArrayList<String>();
						prevWords.add(word);
						backtrack.put(newWord, prevWords);
					}
				}
		}
        System.out.println(backtrack);
        
        return null;
		// generateResult(end, backtrack);
    }

	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("hot"); dict.add("dot"); dict.add("dog"); dict.add("lot"); dict.add("log");
		
		System.out.println(findLadders("hit", "cog", dict));
	}

}
