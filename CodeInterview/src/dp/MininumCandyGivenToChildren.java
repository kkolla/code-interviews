package dp;

import java.util.HashMap;
import java.util.Map;

public class MininumCandyGivenToChildren {
	
	// O(n)
	public static int candy(int[] ratings) {
        int[] lc = new int[ratings.length];
        int[] rc = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            lc[i] = (i == 0 || ratings[i] <= ratings[i - 1]) ? 1 : lc[i - 1] + 1;
        }
        int candy = 0;
        for (int i = ratings.length - 1; i >= 0; i--) {
            rc[i] = (i == ratings.length - 1 || ratings[i] <= ratings[i + 1]) ? 1 : rc[i + 1] + 1;
            candy += Math.max(lc[i], rc[i]);
        }
        return candy;
    }

	// O(n^2)
	public static int candy2(int[] ratings) {
        Map<Integer, Integer> childToCandy = new HashMap<Integer, Integer>();
        int totalCandy = 0;
        while (childToCandy.size() < ratings.length) {
            for (int i = 0; i < ratings.length; i++) {
                if (childToCandy.containsKey(i)) continue; // the i-th child has been given candy
                // check if (1) candy has been given to both left and right chidren
                // or (2) i-th child has lower or equal priority to left and right children
                // if one of them meets, we're able to give candy to the i-th child
                int candy = 0;
                int leftRating = i == 0 ? 0 : ratings[i - 1];
                int rightRating = i == ratings.length - 1 ? 0 : ratings[i + 1];
                int leftCandy = i == 0 ? 0 : (childToCandy.containsKey(i - 1) ? childToCandy.get(i - 1) : -1);
                int rightCandy = i == ratings.length - 1 ? 0 : (childToCandy.containsKey(i + 1) ? childToCandy.get(i + 1) : -1);
                if (leftCandy != -1 && rightCandy != -1) {
                	if (ratings[i] <= Math.min(leftRating, rightRating)) candy = 1;
                	else candy = Math.max(leftCandy, rightCandy) + 1;
            	} else if (ratings[i] <= leftRating && ratings[i] <= rightRating) {
                    candy = 1;
                } else {
                	continue;
                }
                System.out.println("Giving " + i + "-th child " + candy + " candies");
                totalCandy += candy;
                childToCandy.put(i, candy);
            }
        }
        return totalCandy;
    }
	
	public static void main(String[] args) {
		int[] ratings = {4, 1, 3, 3, 5, 2, 7};
		System.out.println(candy(ratings));
	}

}
