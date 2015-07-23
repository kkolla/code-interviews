package recursion;

import java.util.ArrayList;
import java.util.List;

import utils.PrintUtils;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * 
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 */
public class NQueens {
	
	public static List<List<String>> solveNQueens(int n) {
		return solveNQueens(n - 1, new int[n], new ArrayList<List<String>>());
    }
	
	private static List<List<String>> solveNQueens(int row, int[] queenColInRow, List<List<String>> result) {
		if (row >= 0) {
			for (int j = 0; j < queenColInRow.length; j++) {
				// try to place a queen in the col-th column in the current row
				queenColInRow[row] = j;
				// check if it violates the rules
				if (check(row, queenColInRow)) {
					// try placing a queen in the row above
					solveNQueens(row - 1, queenColInRow, result);
				}
			}
		} else {
			// have placed queens on each row in a valid way
			// construct one solution
			List<String> solution = new ArrayList<String>();
			for (int i = 0; i < queenColInRow.length; i++) {
				StringBuilder sb = new StringBuilder("");
				for (int j = 0; j < queenColInRow.length; j++) {
					sb.append(j == queenColInRow[i] ? 'Q' : '.');
				}
				solution.add(sb.toString());
			}
			result.add(solution);
		}
		return result;
	}

	private static boolean check(int row, int[] queenColInRow) {
		for (int i = queenColInRow.length - 1; i > row; i--) {
			if (queenColInRow[i] == queenColInRow[row] || // two queens are in the same column
				Math.abs(queenColInRow[i] - queenColInRow[row]) == i - row) // in the diagonal
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		for (List<String> solution: solveNQueens(5))
			PrintUtils.printList(solution);
	}

}
