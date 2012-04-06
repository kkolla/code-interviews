package recursion;

public class FibonacciNumbers {

	public static long fibonacciUsingMemoization(int n, long[] computed) {
		if (n < 2)
			return n;
		if (computed[n] != 0) {
			return computed[n];
		} else {
			computed[n] = fibonacciUsingMemoization(n - 1, computed)
					+ fibonacciUsingMemoization(n - 2, computed);
			return computed[n];
		}
	}

	public static void main(String[] args) {
		int n = 700;
		System.out.println(fibonacciUsingMemoization(n, new long[n + 1]));
	}

}
