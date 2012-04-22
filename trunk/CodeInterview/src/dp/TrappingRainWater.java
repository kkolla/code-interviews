package dp;

/*
 * Given n non-negative integers representing an elevation map 
 * where the width of each bar is 1, compute how much water 
 * it is able to trap after raining.
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrappingRainWater {

	public static int water(int[] a) {
		if (a.length == 0 || a.length == 1)
			return 0;
		int total = 0;
		int highest = 0;
		for (int i = 1; i < a.length; i++)
			if (a[i] > a[highest])
				highest = i;
		int left = 0;
		for (int i = 1; i < highest; i++)
			if (a[i] < a[left])
				total += a[left] - a[i];
			else
				left = i;
		int right = a.length - 1;
		for (int i = a.length - 2; i > highest; i--)
			if (a[i] < a[right])
				total += a[right] - a[i];
			else
				right = i;
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
