package recursion;

public class PrintMatrixInSpiralOrder {

	// buggy!
	public static void printSpiral(int[][] m, int maxRow, int maxCol, int k) {
		if (maxRow <= 0 || maxCol <= 0) {
			System.out.println();
			return;
		}

		if (maxRow == 1) {
			if (k == 1)
				System.out.print("aaa");
			for (int i = k; i < maxCol; i++)
				System.out.print(m[k][i] + " ");
			System.out.println();
			return;
		}
		if (maxCol == 1) {
			for (int i = k; i < maxRow; i++)
				System.out.print(m[i][k] + " ");
			System.out.println();
			return;
		}

		for (int i = k; i < maxCol - 1; i++)
			System.out.print(m[k][i] + " ");
		// System.out.println();

		for (int i = k; i < maxRow - 1; i++)
			System.out.print(m[i][maxCol - 1 + k] + " ");
		// System.out.println();

		for (int i = maxCol - 1; i >= k + 1; i--)
			System.out.print(m[maxRow - 1 + k][i] + " ");
		// System.out.println();

		for (int i = maxRow - 1; i >= k + 1; i--)
			System.out.print(m[i][k] + " ");
		// System.out.println();

		printSpiral(m, maxRow - 2, maxCol - 2, k + 1);
	}

	public static void main(String[] args) {
		int[][] m = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		printSpiral(m, m.length, m[0].length, 0);

		m = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };

		printSpiral(m, m.length, m[0].length, 0);

		m = new int[][] { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 } };

		printSpiral(m, m.length, m[0].length, 0);

		m = new int[][] { { 1 }, { 2 }, { 3 }, { 4 }, { 5 }, { 6 }, { 7 },
				{ 8 }, { 9 }, { 10 }, { 11 }, { 12 } };

		printSpiral(m, m.length, m[0].length, 0);

		m = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		printSpiral(m, m.length, m[0].length, 0);
	}

}
