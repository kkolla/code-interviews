package recursion;

import utils.CreateUtils;
import utils.PrintUtils;

public class PrintMatrixInSpiralOrder {

	// seems correct but cannot pass LOJ
	public static void printSpiral(int[][] m, int numRows, int numCols, int k) {
		if (numRows == 0 || numRows == 0)
			return;
		if (numRows == 1) {
			for (int i = 0; i < numCols; i++)
				System.out.print(m[k][k + i] + " ");
			return;
		}
		if (numCols == 1) {
			for (int i = 0; i < numRows; i++)
				System.out.print(m[i + k][k] + " ");
			return;
		}

		for (int i = 0; i < numCols - 1; i++) {
			System.out.print(m[k][k + i] + " ");
		}
		for (int i = 0; i < numRows - 1; i++) {
			System.out.print(m[i + k][numCols - 1 + k] + " ");
			// pitfall: +k, instead of -k, meaning offset from left
		}
		for (int i = 0; i < numCols - 1; i++) {
			System.out.print(m[numRows - 1 + k][k + numCols - 1 - i] + " ");
		}
		for (int i = 0; i < numRows - 1; i++) {
			System.out.print(m[k + numRows - 1 - i][k] + " ");
		}
		printSpiral(m, numRows - 2, numCols - 2, k + 1);
	}

	public static void main(String[] args) {
		int[][] m = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		printSpiral(m, m.length, m[0].length, 0);
		System.out.println();

		m = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };

		printSpiral(m, m.length, m[0].length, 0);
		System.out.println();

		m = new int[][] { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 } };

		printSpiral(m, m.length, m[0].length, 0);
		System.out.println();

		m = new int[][] { { 1 }, { 2 }, { 3 }, { 4 }, { 5 }, { 6 }, { 7 },
				{ 8 }, { 9 }, { 10 }, { 11 }, { 12 } };

		printSpiral(m, m.length, m[0].length, 0);
		System.out.println();

		m = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		printSpiral(m, m.length, m[0].length, 0);
		System.out.println();

		m = CreateUtils.randNonNegMatrix(10, 20, false);
		PrintUtils.print2DArray(m);
		printSpiral(m, m.length, m[0].length, 0);
		System.out.println();
	}

}
