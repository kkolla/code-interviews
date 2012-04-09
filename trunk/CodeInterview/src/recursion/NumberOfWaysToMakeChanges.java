package recursion;

public class NumberOfWaysToMakeChanges {

	public static int makeChangesRecursive(int[] coins, int c, int money) {
		if (money == 0)
			return 1;

		if (c == coins.length)
			return 0;

		int ways = 0;
		for (int i = 0;; i++) {
			int coin = coins[c];
			if (coin * i <= money)
				ways += makeChangesRecursive(coins, c + 1, money - coin * i);
			else
				break;
		}
		return ways;
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5, 10 };
		int money = 10;
		System.out.println(makeChangesRecursive(coins, 0, money));

	}

}
