package dp;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class MininumSumPathInTriangle {
	
	// m[i]: minimum sum to this element
	// answer: m[0]
	// init: m[i] = triangle[maxRow][i]
	// m[i] = triangle[currRow][i] + min(m[currRow+1][i], m[currRow+1][i+1])
	
	public int minimumTotal(List<List<Integer>> triangle) {
        int[] m = new int[triangle.size()];
        
        // init for the last row
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++)
        	m[i] = triangle.get(triangle.size() - 1).get(i);
        
        for (int j = triangle.size() - 2; j >= 0; j--)
        	for (int i = 0; i < triangle.get(j).size(); i++)
        		m[i] = triangle.get(j).get(i) + Math.min(m[i],  m[i + 1]);
        
        return m[0];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
