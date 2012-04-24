package array;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * Set Matrix Zeroes: Given a m x n matrix, 
 * if an element is 0, set its entire 
 * row and column to 0. Do it in place. 
 */
public class SetMatrixZeros {

	public static int[][] setZeros(int[][] m) {
		boolean firstRowZero = false, firstColZero = false;
		for (int i = 0; i < m[0].length; i++)
			if (m[0][i] == 0) {
				firstRowZero = true;
				break;
			}
		for (int i = 0; i < m.length; i++)
			if (m[i][0] == 0) {
				firstColZero = true;
				break;
			}
		for (int i = 1; i < m.length; i++)
			for (int j = 1; j < m[0].length; j++)
				if (m[i][j] == 0) {
					m[0][j] = 0;
					m[i][0] = 0;
				}
		for (int i = 1; i < m.length; i++)
			for (int j = 1; j < m[0].length; j++)
				if (m[0][j] == 0 || m[i][0] == 0)
					m[i][j] = 0;
		if (firstRowZero)
			for (int i = 0; i < m[0].length; i++)
				m[0][i] = 0;
		if (firstColZero)
			for (int i = 0; i < m.length; i++)
				m[i][0] = 0;
		return m;
	}

	public static void main(String[] args) {
		int[][] m = CreateUtils.randNonNegMatrix(10, 2, false);
		PrintUtils.print2DArray(m);
		System.out.println();
		PrintUtils.print2DArray(setZeros(m));
	}

}
