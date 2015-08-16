package dp;

/*
 * Given n non-negative integers representing an elevation map 
 * where the width of each bar is 1, compute how much water 
 * it is able to trap after raining.
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrappingRainWater {

	// O(n), O(1)
	public int trapRainWater(int[] heights) {
        if (heights.length == 0) return 0;
        
        int highestIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[highestIndex])
                highestIndex = i;
        }
        
        int water = 0;
        for (int i = 0, leftHighest = 0; i < highestIndex; i++) {
            if (heights[i] > leftHighest) 
                leftHighest = heights[i];
            else
                water += leftHighest - heights[i];
        }
        for (int i = heights.length - 1, rightHighest = 0; i >= highestIndex + 1; i--) {
            if (heights[i] > rightHighest) 
                rightHighest = heights[i];
            else
                water += rightHighest - heights[i];
        }
        
        return water;
    }
	
	public static int trap(int[] height) {
		if (height == null || height.length <= 1) return 0;
		
		int[] l = new int[height.length]; // l[i]: max height on the left of the i-th bar
		int[] r = new int[height.length]; // r[i]: max height on the right of the i-th bar

		for (int i = 1; i < height.length; i++)
			l[i] = Math.max(l[i - 1], height[i - 1]);
		for (int i = height.length - 2; i >= 0; i--)
			r[i] = Math.max(r[i + 1], height[i + 1]);
		
		int water = 0;
		for (int i = 0; i < height.length; i++) {
			int smallerHeightLeftAndRight = Math.min(l[i], r[i]);
			if (smallerHeightLeftAndRight > height[i]) {
				// trapped water is the difference
				water += smallerHeightLeftAndRight - height[i];
			}
		}
		return water;
    }
	
	public static void main(String[] s) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));
	}
}
