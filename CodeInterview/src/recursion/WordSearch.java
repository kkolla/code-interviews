package recursion;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.

 * Each word must be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once in a word.

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
 */
public class WordSearch {
	
	public static boolean exist(char[][] board, int x, int y, String word) {
		if (word.isEmpty()) return true;
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
	
		char c = word.charAt(0);
		if (board[x][y] != c) return false;
		word = word.substring(1);
		
		board[x][y] = '#';
		boolean found = exist(board, x - 1, y, word) ||
				exist(board, x + 1, y, word) ||
				exist(board, x, y - 1, word) ||
				exist(board, x, y + 1, word);
		board[x][y] = c;

		return found;
	}
	
	public static boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				if (exist(board, i, j, word)) return true;
		return false;
    }

	public static void main(String[] args) {
		char[][] board = { {'A', 'B', 'C', 'E'},
		  {'S', 'F', 'C', 'S'},
		  {'A', 'D', 'E', 'E'}};
		System.out.println(exist(board, "ABCCED"));
		System.out.println(exist(board, "SEE"));
		System.out.println(exist(board, "ABCB"));
	}

}
