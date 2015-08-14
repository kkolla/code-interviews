package dp;

public class BestTimeToBuyAndSellStockIV {

	// https://gist.github.com/ElninoFong/d08051d98e634991cd93
	// local[i][j]: the max profit for completing at most j transactions in day i, 
	//              and the last transaction must be completed in day j
	// global[i][j]: the max profit for completing at most j transactions in day i
	// answer: global[prices.length - 1][k]
	// local[i][j] = max(global[i - 1][j - 1] + max(diff, 0), local[i - 1][j] + diff)
    // global[i][j] = max(local[i][j], global[i - 1][j])，
	public int maxProfit(int k, int[] prices) {
		if (k > prices.length) {
            // unlimited transactions
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] - prices[i - 1] > 0) 
                    profit += prices[i] - prices[i - 1];
            }
            return profit;
        }
		
		int[][] local = new int[prices.length + 1][k + 1];
		int[][] global = new int[prices.length + 1][k + 1];
		
		for (int i = 1; i < prices.length; i++) {
			int delta = prices[i] - prices[i - 1];
			for (int j = 1; j <= k; j++) {
				local[i][j] = Math.max(
					global[i - 1][j - 1] + Math.max(delta, 0),
					local[i - 1][j] + delta); // must complete the last transaction in day i
				global[i][j] = Math.max(local[i][j], global[i - 1][j]);
			}
		}
		
		return global[prices.length - 1][k];
    }
}
