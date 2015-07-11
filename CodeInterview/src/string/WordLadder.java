package string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary, find the length of shortest transformation sequence from beginWord to endWord, such that:

 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,

 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class WordLadder {
	
	public static int ladderLength(String beginWord, String endWord, Set<String> wordDict) {		
		Queue<String> wordQueue = new LinkedList<String>();
		Queue<Integer> distanceQueue = new LinkedList<Integer>();
		
		wordDict.add(endWord); // the end word doesn't need to be present in dictionary
		wordQueue.add(beginWord);
		distanceQueue.add(1);
		
		while (!wordQueue.isEmpty()) {
			String word = wordQueue.poll();
			int distance = distanceQueue.poll();
			
			if (word.equals(endWord)) return distance;
			
			for (int i = 0; i < beginWord.length(); i++)
				for (char c = 'a'; c <= 'z'; c++) {
					if (word.charAt(i) == c) continue;
					String newWord = word.substring(0, i) + c + word.substring(i + 1);
					if (wordDict.contains(newWord)) {
						wordQueue.add(newWord);
						distanceQueue.add(distance + 1);
						wordDict.remove(newWord);
					}
				}
		}
		
		return 0;
    }

	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("hot"); dict.add("dot"); dict.add("dog"); dict.add("lot"); dict.add("log");
		
		System.out.println(ladderLength("hit", "cog", dict));
	}

}
