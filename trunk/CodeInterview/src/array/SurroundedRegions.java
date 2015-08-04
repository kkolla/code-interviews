package array;

import java.util.LinkedList;
import java.util.Queue;

import utils.PrintUtils;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * 
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 */
public class SurroundedRegions {
	
	public static void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
		
		// flood fill the first and last rows
		for (int y = 0; y < board[0].length; y++) {
			floodFill(board, 0, y);
			floodFill(board, board.length - 1, y);
		}
		
		// flood fill the first and last columns
		for (int x = 0; x < board.length; x++) {
			floodFill(board, x, 0);
			floodFill(board, x, board[0].length - 1);
		}
		
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				if (board[x][y] == 'O') // surrounded region after flooding
					board[x][y] = 'X';
				else if (board[x][y] == 'F')
					board[x][y] = 'O';
			}
		}
    }
	
	private static void floodFill(char[][] board, int x, int y) {
		// use iterative BFS to avoid stack overflow
		Queue<Coordinate> q = new LinkedList<Coordinate>();
		q.add(new Coordinate(x, y));
		while (!q.isEmpty()) {
			Coordinate c = q.poll();
			if (c.x < 0 || c.x > board.length - 1 || c.y < 0 || c.y > board[0].length - 1 
				|| board[c.x][c.y] != 'O') {
				// skip invalid coordinate
				continue;
			}
			// fill the current position
			board[c.x][c.y] = 'F';
			q.add(new Coordinate(c.x - 1, c.y));
			q.add(new Coordinate(c.x, c.y - 1));
			q.add(new Coordinate(c.x + 1, c.y));
			q.add(new Coordinate(c.x, c.y + 1));
		}
	}
	
	static class Coordinate {
		int x;
		int y;
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main (String[] s) {
		char[][] board = { {'0', '0', '0'}, {'0', '0', '0'}, {'0', '0', '0'}};
		solve(board);
		for (char[] row : board)
			System.out.println(row);
	}
}
