package dp;

import java.util.ArrayList;
import java.util.List;

import utils.PrintUtils;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 *     [1],
 *    [1,1],
 *   [1,2,1],
 *  [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 *
 */
public class PascalsTriangle {
	
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (numRows == 0) return result;
		
		List<Integer> zeroRow = new ArrayList<Integer>();
		zeroRow.add(1);
		result.add(zeroRow);
		
		for (int row = 1; row < numRows; row++) {
			List<Integer> prevRow = result.get(row - 1);
			List<Integer> currRow = new ArrayList<Integer>();
			for (int i = 0; i < row + 1; i++) {
				int topLeft = i == 0 ? 0 : prevRow.get(i - 1);
				int topRight = i == prevRow.size() ? 0 : prevRow.get(i);
				currRow.add(topLeft + topRight);
			}
			result.add(currRow);
		}

		return result;
    }

	public static void main(String[] args) {
		for (List<Integer> row : generate(5)) {
			PrintUtils.printList(row);
		}
	}

}
