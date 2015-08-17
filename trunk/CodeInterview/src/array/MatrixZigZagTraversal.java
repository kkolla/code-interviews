package array;

public class MatrixZigZagTraversal {
	public int[] printZMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        
        int rows = matrix.length, cols = matrix[0].length;
        int i = 0, j = 0, c = 0;
        int[] result = new int[rows * cols];
        
        do {
            // start
            result[c++] = matrix[i][j];
            
            // move right if possible
            if (j + 1 < cols) j++;
            // move down if possible
            else if (i + 1 < rows) i++;
            // cannot move right or down, it's over
            else break;
            
            // move south west
            while (i + 1 < rows && j - 1 >= 0) {
                result[c++] = matrix[i][j];
                i++;
                j--;
            }
            
            result[c++] = matrix[i][j];
            
            // move down if possible
            if (i + 1 < rows) i++;
            // move right if possible
            else if (j + 1 < cols) j++;
            else break;
            
            // move north east
            while (i - 1 >= 0 && j + 1 < cols) {
                result[c++] = matrix[i][j];
                i--;
                j++;
            }
            
        } while (i < rows && j < cols);
        
        return result;
    }
	
	// shorter: https://github.com/kamyu104/LintCode/blob/master/C++/matrix-zigzag-traversal.cpp
}
