package dp;

/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {

	public static int stairs(int n) {
		if (n < 3)
			return n;
		int minusOne = 1, minusTwo = 1;
		int stairs = -1;
		for (int i = 2; i <= n; i++) {
			stairs = minusOne + minusTwo;
			minusTwo = minusOne;
			minusOne = stairs;
		}
		return stairs;
	}

	public static void main(String[] args) {
		for (int i = 0; i <= 10; i++)
			System.out.println(stairs(i));
	}

}
