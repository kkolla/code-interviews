package dp;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction 
 * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 */
public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE, profit = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.min(buy, prices[i - 1]);
            profit = Math.max(profit, prices[i] - buy);
        }
        return profit;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
