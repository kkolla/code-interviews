package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.PrintUtils;

public class MinimumNumberOfChanges {

	public static int minimumCoins(int[] coins, int money,
			List<Integer> usedCoins) {
		Map<Integer, Integer> backtrack = new HashMap<Integer, Integer>();
		int[] nums = new int[money + 1];
		nums[0] = 0;
		backtrack.put(nums[0], null);
		for (int i = 1; i <= money; i++) {
			int min = Integer.MAX_VALUE;
			int coin = -1;
			for (int j = 0; j < coins.length; j++)
				if (i - coins[j] >= 0) {
					min = Math.min(min, nums[i - coins[j]]);
					coin = coins[j];
				}
			nums[i] = min + 1;
			backtrack.put(i, i - coin);
		}
		// PrintUtils.printMap(backtrack);
		int left = money;
		do {
			Integer previous = backtrack.get(left);
			usedCoins.add(left - previous);
			left -= left - previous;
		} while (left != 0);

		return nums[money];
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5, 10 };
		int money = 11;

		List<Integer> usedCoins = new ArrayList<Integer>();
		System.out.println(minimumCoins(coins, money, usedCoins));
		PrintUtils.printList(usedCoins);

		money = 12;
		usedCoins = new ArrayList<Integer>();
		System.out.println(minimumCoins(coins, money, usedCoins));
		PrintUtils.printList(usedCoins);

		money = 13;
		usedCoins = new ArrayList<Integer>();
		System.out.println(minimumCoins(coins, money, usedCoins));
		PrintUtils.printList(usedCoins);

		money = 14;
		usedCoins = new ArrayList<Integer>();
		System.out.println(minimumCoins(coins, money, usedCoins));
		PrintUtils.printList(usedCoins);

		money = 15;
		usedCoins = new ArrayList<Integer>();
		System.out.println(minimumCoins(coins, money, usedCoins));
		PrintUtils.printList(usedCoins);

		money = 108;
		usedCoins = new ArrayList<Integer>();
		System.out.println(minimumCoins(coins, money, usedCoins));
		PrintUtils.printList(usedCoins);
	}
}
