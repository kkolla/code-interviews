package recursion;

import java.util.ArrayList;
import java.util.List;

import utils.CreateUtils;
import utils.PrintUtils;

public class PrintMatrixInSpiralOrder {

	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) return result;
        
        int rows = matrix.length, cols = matrix[0].length;
        int numSpirals = (Math.min(rows, cols) + 1) / 2;
        for (int offset = 0; offset < numSpirals; offset++) {
            // from left to right in the top row
            for (int j = offset; j < cols - offset; j++)
                result.add(matrix[offset][j]);
            
            // from top to bottom in the rightmost column, excluding the topmost element added before
            for (int i = 1 + offset; i < rows - offset; i++)
                result.add(matrix[i][cols - 1 - offset]);
            
            if (offset == rows - 1 - offset) break; // don't proceed if the topmost row and bottommost row are the same 
            // from right to left in the bottom row, excluding the rightmost element added before
            for (int j = cols - offset - 2; j >= offset; j--)
                result.add(matrix[rows - 1 - offset][j]);
            
            if (offset == cols - 1 - offset) break; // don't proceed if the leftmost row and rightmost row are the same 
            // from bottom to top in the leftmost column, excluding the bottomost and topmost elements added before
            for (int i = rows - offset - 2; i >= offset + 1; i--)
                result.add(matrix[i][offset]);
        }
        return result;
    }
	
	private static void printSpiral(int[][] matrix) {
		PrintUtils.printList(spiralOrder(matrix));
	}

	public static void main(String[] args) {
		int[][] m = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		printSpiral(m);
		System.out.println();

		m = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };

		printSpiral(m);
		System.out.println();

		m = new int[][] { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 } };

		printSpiral(m);
		System.out.println();

		m = new int[][] { { 1 }, { 2 }, { 3 }, { 4 }, { 5 }, { 6 }, { 7 },
				{ 8 }, { 9 }, { 10 }, { 11 }, { 12 } };

		printSpiral(m);
		System.out.println();

		m = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		printSpiral(m);
		System.out.println();

		m = CreateUtils.randNonNegMatrix(10, 20, false);
		PrintUtils.print2DArray(m);
		printSpiral(m);
		System.out.println();
	}

}
