package combinatorics;

import java.util.ArrayList;

public class AllValidEightQueensBoard {

	public static ArrayList<String[]> findValidBoard(int n) {
		ArrayList<String[]> l = new ArrayList<String[]>();
		placeRow(0, n, l, new int[n]);
		return l;
	}

	public static void placeRow(int row, int n, ArrayList<String[]> l,
			int[] rowToCol) {
		if (row == n) {
			String[] ss = new String[n];
			for (int i = 0; i < n; i++) {
				StringBuffer sb = new StringBuffer("");
				for (int j = 0; j < rowToCol[i]; j++)
					sb.append('.');
				sb.append('Q');
				for (int j = rowToCol[i] + 1; j < n; j++)
					sb.append('.');
				ss[i] = sb.toString();
			}
			l.add(ss);
			return;
		}
		// try placing a queen to every column
		for (int i = 0; i < n; i++) {
			rowToCol[row] = i;
			boolean valid = true;
			// check whether constraints still hold
			for (int j = 0; j < row; j++) {
				if (rowToCol[j] == rowToCol[row]
						|| Math.abs(rowToCol[j] - rowToCol[row]) == row - j) {
					valid = false;
					break;
				}
			}
			if (valid)
				placeRow(row + 1, n, l, rowToCol);
		}
	}

	public static void main(String[] args) {
		System.out.println(findValidBoard(8).size());
	}

}
