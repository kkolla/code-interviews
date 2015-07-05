package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.PrintUtils;
import datastructure.SimpleTrie;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once in a word.
 *
 * For example,
 * Given words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * Return ["eat","oath"].
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 *
 */
public class WordSearchII {
	
	public static void findWords(char[][] board, SimpleTrie trie, int x, int y, Set<String> foundWords, String s) {
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
		if (board[x][y] == '#') return;
		
		char c = board[x][y];
		s = s + c;
		
		if (!trie.startsWith(s)) return; // pruning
		if (trie.search(s)) foundWords.add(s);
				
		board[x][y] = '#';
		findWords(board, trie, x - 1, y, foundWords, s);
		findWords(board, trie, x + 1, y, foundWords, s);
		findWords(board, trie, x, y - 1, foundWords, s);
		findWords(board, trie, x, y + 1, foundWords, s);
		board[x][y] = c;
	}
	
	public static List<String> findWords(char[][] board, String[] words) {
		SimpleTrie trie = new SimpleTrie();
		for (String word : words) trie.insert(word);
		
		Set<String> foundWords = new HashSet<String>();

		for (int x = 0; x < board.length; x++)
			for (int y = 0; y < board[0].length; y++)
				findWords(board, trie, x, y, foundWords, "");
		
		List<String> result = new ArrayList<String>();
		result.addAll(foundWords);
        return result;
    }

	public static void main(String[] args) {
		char[][] board = { {'o','a','a','n'},
		  {'e','t','a','e'},
		  {'i','h','k','r'},
		  {'i','f','l','v'}};
		String[] words = {"oath","pea","eat","rain"};
		PrintUtils.printList(findWords(board, words));
	}

}
