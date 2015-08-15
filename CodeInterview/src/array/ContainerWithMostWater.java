package array;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point 
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints 
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis 
 * forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 *
 */
public class ContainerWithMostWater {
	public int maxArea(int[] heights) {
        int maxWater = 0;
        int l = 0, r = heights.length - 1;
        while (l < r) {
        	int water = (r - l) * Math.min(heights[l], heights[r]);
        	maxWater = Math.max(maxWater, water);
        	if (heights[l] < heights[r]) l++;
        	else r--;
        }
        return maxWater;
    }
}
