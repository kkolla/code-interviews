package dp;

import utils.CreateUtils;

/*
 * Given a m*n grid starting from (1, 1). At any point (x, y), 
 * you has two choices for the next move:
 * 1) move to (x+y, y);
 * 2) move to (x, y+x);
 * From point (1, 1), how to move to (m, n) in least moves? (or there's no such a path)
 */
public class LeastJumpMovesInGrid {

	// return value is not same to the below two functions..
	public static int leastMovesIterative(int m, int n) {
		int[][] moves = new int[m + 1][n + 1];
		for (int x = 1; x <= m; x++)
			for (int y = 1; y <= n; y++) {
				int mvs = moves[x][y] + 1;
				if (x + y <= m) {
					int old = moves[x + y][y];
					moves[x + y][y] = old == 0 ? mvs : Math.min(old, mvs);
				}
				if (x + y <= n) {
					int old = moves[x][x + y];
					moves[x][x + y] = old == 0 ? mvs : Math.min(old, mvs);
				}
			}
		return moves[m][n] != 0 ? moves[m][n] : -1;
	}

	public static int leastMovesRecursiveTopDown(int x, int y) {
		if (x < 1 || y < 1)
			return -1;
		if (x == 1 && y == 1)
			return 0;
		int moves1 = leastMovesRecursiveTopDown(x, y - x);
		int moves2 = leastMovesRecursiveTopDown(x - y, y);
		if (moves1 == -1 && moves2 == -1)
			return -1;
		else if (moves1 == -1)
			return moves2 + 1;
		else if (moves2 == -1)
			return moves1 + 1;
		else
			return Math.min(moves1, moves2) + 1;
	}

	public static int leastMovesRecursiveBottomUp(int x, int y, int m, int n) {
		if (x > m || y > n)
			return -1;
		if (x == m && y == n)
			return 0;
		int moves1 = leastMovesRecursiveBottomUp(x + y, y, m, n);
		int moves2 = leastMovesRecursiveBottomUp(x, x + y, m, n);
		if (moves1 == -1 && moves2 == -1)
			return -1;
		else if (moves1 == -1)
			return moves2 + 1;
		else if (moves2 == -1)
			return moves1 + 1;
		else
			return Math.min(moves1, moves2) + 1;
	}

	public static void main(String[] args) {
		int m = CreateUtils.randNonNegInt(20);
		int n = CreateUtils.randNonNegInt(20);
		System.out.println("m: " + m + " n: " + n + " moves: "
				+ leastMovesIterative(m, n) + " moves:"
				+ leastMovesRecursiveTopDown(m, n) + " moves:"
				+ leastMovesRecursiveBottomUp(1, 1, m, n));
	}
}
