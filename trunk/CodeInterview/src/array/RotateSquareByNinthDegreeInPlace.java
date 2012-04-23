package array;

import utils.CreateUtils;
import utils.PrintUtils;

public class RotateSquareByNinthDegreeInPlace {

	public static int[][] rotateLeft(int[][] m) {
		int n = m.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int start = layer;
			int end = n - layer - 1; // -1 because the last is the first of
										// different rows/cols
			for (int i = start; i < end; i++) {
				int offset = i - start;
				int topLeft = m[start][i];
				m[start][i] = m[start + offset][end];
				m[start + offset][end] = m[end][end - offset];
				m[end][end - offset] = m[end - offset][start];
				m[end - offset][start] = topLeft;
			}
		}
		return m;
	}

	public static int[][] rotateRight(int[][] m) {
		int n = m.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int start = layer;
			int end = n - layer - 1;
			for (int i = start; i < end; i++) {
				int offset = i - start;
				int topLeft = m[start][i];
				m[start][i] = m[end - offset][start];
				m[end - offset][start] = m[end][end - offset];
				m[end][end - offset] = m[i][end];
				m[i][end] = topLeft;
			}
		}
		return m;
	}

	public static void main(String[] args) {
		int[][] m = CreateUtils.randNonNegMatrix(10, 100, true);
		PrintUtils.print2DArray(m);
		PrintUtils.print2DArray(rotateRight(m));
		PrintUtils.print2DArray(rotateLeft(m));
	}

}
