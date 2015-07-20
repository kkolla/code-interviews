package dp;

import java.util.Stack;

public class MaximalRectangle {

	 public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int maxArea = 0;
        int[] height = new int[matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
            maxArea = Math.max(maxArea, maxArea(height));
        }
        return maxArea;
    }
    
    public static int maxArea(int[] height) {
        int[] h = new int[height.length + 1];
        for (int i = 0; i < height.length; i++)
        	h[i] = height[i];
        h[height.length] = 0;

        int maxArea = 0;
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < h.length; i++) {
        	if (s.isEmpty() || h[i] > h[s.peek()]) s.push(i);
        	else {
        		int t = s.pop();
        		int width = s.isEmpty() ? i : i - 1 - s.peek();
        		maxArea = Math.max(maxArea, width * h[t]);
        		i--;
        	}
        }
        return maxArea;
    }
    
    public static void main(String[] s) {
    	char[][] matrix = { {1, 1} };
    	System.out.println(maximalRectangle(matrix));
    }
}
