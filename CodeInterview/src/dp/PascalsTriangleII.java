package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 */
public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>(rowIndex + 1);
        row.add(1);
        for (int i = 0; i < rowIndex; i++) {
            for (int j = row.size() - 2; j >= 0; j--) {
                int prevLeft = row.get(j);
                int prevRight = row.get(j + 1);
                row.set(j + 1, prevLeft + prevRight);
            }
            row.add(1);
        }
        return row;
    }
}
