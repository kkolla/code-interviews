package dp;

import java.util.Stack;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * Given: A two-dimensional array b (M rows, N columns) of Boolean values ("0" and "1"). 
 * Required: Find the largest (most elements) rectangular subarray containing all ones.
 * 
 * http://www.drdobbs.com/database/184410529 O(mn)
 * http://www.seas.gwu.edu/~simhaweb/cs153/lectures/module6/module6.html O(mnn)
 */
public class MaxAllOneSubMatrix {

	// O(mnn)
	public static void findMaxAllOneSubMatrix(int[][] m) {
		final int rows = m.length, cols = m[0].length;

		// cache for saving the maximum number of ones for each column
		int[] maxOneCounts = new int[cols];

		// answers
		int bestTopLeftRow = -1, bestTopLeftCol = -1, bestBotRightRow = -1, bestBotRightCol = -1;
		int maxArea = 0;

		for (int i = 0; i < rows; i++) {
			// update cache
			for (int j = 0; j < cols; j++) {
				maxOneCounts[j] = 0;
				for (int row = i; row < rows && m[row][j] == 1; row++)
					maxOneCounts[j]++;
			}

			for (int j = 0; j < cols; j++) {
				// grow the sub matrix of ones
				// indicator of the largest row we need to search until
				int maxRow = rows - 1;
				int jj = j;
				while (jj < cols && m[i][jj] == 1) {
					// get cached count of ones
					// go as deep as possible in constant time
					int deepestRow = i + maxOneCounts[jj] - 1;
					maxRow = Math.min(maxRow, deepestRow);

					// compute the area of found matrix of ones
					int width = jj - j + 1;
					int height = maxRow - i + 1;
					int area = width * height;

					// update answers if larger
					if (area > maxArea) {
						maxArea = area;
						bestTopLeftRow = i;
						bestTopLeftCol = j;
						bestBotRightRow = deepestRow;
						bestBotRightCol = jj;
					}
					jj++;
				}
			}
		}

		if (bestTopLeftRow == -1)
			System.out.println("there's no 1 in the matrix");
		else
			System.out.println("bestTopLeftRow: " + bestTopLeftRow
					+ ", bestTopLeftCol: " + bestTopLeftCol
					+ ", bestBotRightRow: " + bestBotRightRow
					+ ", bestBotRightCol: " + bestBotRightCol);
	}

	// O(mn)
	// boosted by calculating as max rectangle in histogram for iterating rows
	public static void findMaxAllOneSubMatrixBoosted(int[][] m) {
		final int rows = m.length, cols = m[0].length;

		// cache, also histogram
		int[] maxOneCounts = new int[cols];

		// answers
		int bestTopLeftRow = -1, bestTopLeftCol = -1, bestBotRightRow = -1, bestBotRightCol = -1;
		int maxArea = 0;

		// go upwards this time for linear cache update
		for (int i = rows - 1; i >= 0; i--) {
			// update cache
			for (int j = 0; j < cols; j++) {
				if (m[i][j] == 0) {
					maxOneCounts[j] = 0;
				} else {
					if (i != rows - 1)
						maxOneCounts[j] = maxOneCounts[j] + 1;
					else
						maxOneCounts[j] = 1;
				}
			}

			Stack<Integer> s = new Stack<Integer>();
			int[] widths = new int[cols];
			// find max rectangle in histogram
			for (int j = 0; j < cols; j++) {
				while (!s.isEmpty()
						&& maxOneCounts[s.peek()] >= maxOneCounts[j])
					s.pop();
				int leftOffset = s.isEmpty() ? j : j - s.peek() - 1;
				widths[j] += leftOffset;
				s.push(j);
			}
			s = new Stack<Integer>();
			for (int j = cols - 1; j >= 0; j--) {
				while (!s.isEmpty()
						&& maxOneCounts[s.peek()] >= maxOneCounts[j])
					s.pop();
				int rightOffset = s.isEmpty() ? cols - j - 1 : s.peek() - j - 1;
				widths[j] += rightOffset + 1;
				s.push(j);
			}
			for (int j = 0; j < cols; j++) {
				int area = widths[j] * maxOneCounts[j];
				if (area > maxArea) {
					maxArea = area;
					bestTopLeftRow = i;
					bestTopLeftCol = j;
					bestBotRightRow = i + maxOneCounts[j] - 1;
					bestBotRightCol = j + widths[j] - 1;
				}
			}
		}

		if (bestTopLeftRow == -1)
			System.out.println("there's no 1 in the matrix");
		else
			System.out.println("bestTopLeftRow: " + bestTopLeftRow
					+ ", bestTopLeftCol: " + bestTopLeftCol
					+ ", bestBotRightRow: " + bestBotRightRow
					+ ", bestBotRightCol: " + bestBotRightCol);
	}

	public static void main(String[] args) {
		int[][] m = CreateUtils.createRandom2DIntArray(10, 2, false);
		PrintUtils.print2DArray(m);
		System.out.println("first method:");
		findMaxAllOneSubMatrix(m);
		System.out.println("second method:");
		findMaxAllOneSubMatrixBoosted(m);
	}

}
