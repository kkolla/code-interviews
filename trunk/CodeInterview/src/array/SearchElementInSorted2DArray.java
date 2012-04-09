package array;

/*
 Given a sorted 2-D array (M x N) containing integers with the following properties:    
 * All integers in any row are sorted left to right,    
 * The first integer in any row is greater than the last integer in the previous row
 E.g.
 1   3   5   7
 10  11  16  20
 23  30  34  50
 */
public class SearchElementInSorted2DArray {

	// deem the 2-d array as 1-d array then apply binary search
	private static boolean search(int[][] m, int key) {
		int left = 0, right = m.length * m[0].length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int row = mid / m[0].length;
			int col = mid % m[0].length;
			if (m[row][col] == key)
				return true;
			else if (m[row][col] > key) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] m = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		for (int i = 0; i < 52; i++) {
			System.out
					.println("search for: " + i + ", result: " + search(m, i));
		}
	}

}
