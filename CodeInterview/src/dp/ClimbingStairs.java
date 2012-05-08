package dp;

/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {

	public static long stairs(int n) {
		if (n < 3)
			return n;
		long minusOne = 1, minusTwo = 1;
		long stairs = -1;
		for (int i = 2; i <= n; i++) {
			stairs = minusOne + minusTwo;
			minusTwo = minusOne;
			minusOne = stairs;
		}
		return stairs;
	}

	// if 1, 2, 3 steps each time are allowed
	public static long stairsWithThree(int n) {
		if (n <= 2)
			return n;
		if (n == 3)
			return 4;
		long minusThree = 1, minusTwo = 2, minusOne = 4;
		long stairs = -1;
		for (int i = 4; i <= n; i++) {
			stairs = minusThree + minusTwo + minusOne;
			minusOne = stairs;
			minusTwo = minusOne;
			minusThree = minusTwo;
		}
		return stairs;
	}

	public static void main(String[] args) {
		for (int i = 0; i <= 30; i++)
			System.out.println(stairs(i));
	}

}
