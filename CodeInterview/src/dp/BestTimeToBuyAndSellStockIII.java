package dp;

import utils.PrintUtils;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note:
 * You may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 *
 */
public class BestTimeToBuyAndSellStockIII {
	
	// http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-iii-java/
	//Comparing to I and II, III limits the number of transactions to 2. 
	// This can be solve by "devide and conquer". 
	// We use left[i] to track the maximum profit for transactions before i, 
	// and use right[i] to track the maximum profit for transactions after i.
	// You can use the following example to understand the Java solution:
	// Prices: 1 4 5 7 6 3 2 9
	// left = [0, 3, 4, 6, 6, 6, 6, 8]
	// right= [8, 7, 7, 7, 7, 7, 7, 0]
	
	public static int maxProfit(int[] prices) {
		if (prices.length == 0) return 0;
		
		int[] left = new int[prices.length];
		int[] right = new int[prices.length];
		
		left[0] = 0;
		int buy = Integer.MAX_VALUE, profit = 0;
		for (int i = 1; i < prices.length; i++) {
			buy = Math.min(buy, prices[i - 1]);
			profit = Math.max(profit, prices[i] - buy);
			left[i] = profit;
		}
		
		right[prices.length - 1] = 0;
		int sell = Integer.MIN_VALUE;
		profit = 0;
		for (int i = prices.length - 2; i >= 0; i--) {
			sell = Math.max(sell, prices[i + 1]);
			profit = Math.max(profit, sell - prices[i]);
			right[i] = profit;
		}
		
		PrintUtils.printArray(left);
		PrintUtils.printArray(right);

		
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++)
			maxProfit = Math.max(maxProfit, left[i] + right[i]);
		return maxProfit;
	}
	
	// simpler: http://www.cnblogs.com/grandyang/p/4281975.html

	public static void main(String[] args) {
		int[] prices = {1, 4, 2, 8, 3, 4};
		System.out.println(maxProfit(prices));
	}

}
