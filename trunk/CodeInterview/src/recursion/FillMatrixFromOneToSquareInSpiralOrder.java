package recursion;

import utils.CreateUtils;
import utils.PrintUtils;

public class FillMatrixFromOneToSquareInSpiralOrder {

	public static int[][] fill(int[][] m, int numRows, int numCols, int count,
			int k) {
		if (numRows == 0 || numRows == 0)
			return m;
		if (numRows == 1) {
			for (int i = 0; i < numCols; i++)
				m[k][k + i] = count++;
			return m;
		}
		if (numCols == 1) {
			for (int i = 0; i < numRows; i++)
				m[i + k][k] = count++;
			return m;
		}

		for (int i = 0; i < numCols - 1; i++) {
			m[k][k + i] = count++;
		}
		for (int i = 0; i < numRows - 1; i++) {
			m[i + k][numCols - 1 + k] = count++;
		}
		for (int i = 0; i < numCols - 1; i++) {
			m[numRows - 1 + k][k + numCols - 1 - i] = count++;
		}
		for (int i = 0; i < numRows - 1; i++) {
			m[k + numRows - 1 - i][k] = count++;
		}
		return fill(m, numRows - 2, numCols - 2, count, k + 1);
	}

	public static void main(String[] args) {
		int n = CreateUtils.randNonNegInt(10);
		PrintUtils.print2DArray(fill(new int[n][n], n, n, 1, 0));
	}

}
