package dp;

public class FibonacciNumbers {

	public static long fibnacciUsingDP(int n) {
		if (n <= 2)
			return n - 1;
		int p1 = 1, p2 = 0, c = -1;
		for (int i = 3; i <= n; i++) {
			c = p1 + p2;
			p2 = p1;
			p1 = c;
		}
		return c;
	}

	public static long fibonacciUsingMemoization(int n, long[] computed) {
		if (n <= 2)
			return n - 1;
		if (computed[n] != 0) {
			return computed[n];
		} else {
			computed[n] = fibonacciUsingMemoization(n - 1, computed)
					+ fibonacciUsingMemoization(n - 2, computed);
			return computed[n];
		}
	}

	public static void main(String[] args) {
		int n = 7;
		System.out.println(fibonacciUsingMemoization(n, new long[n + 1]) + " "
				+ fibnacciUsingDP(n));
	}

}
