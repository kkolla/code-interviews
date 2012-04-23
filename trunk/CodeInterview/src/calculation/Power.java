package calculation;

public class Power {

	// O(log(y))? cannot pass the large input, perhaps because of stack memory
	public static double powerRecursive(double x, int y) {
		if (y < 0)
			return 1.0 / powerRecursive(x, -y);
		if (y == 0)
			return 1;
		if (y == 1)
			return x;
		double t = powerRecursive(x, y / 2);
		double power = t * t;
		if (y % 2 == 1)
			power *= x;
		return power;
	}

	public static double powerIterative(double x, int y) {
		if (y == 0)
			return 1;
		if (y == 1)
			return x;
		boolean negative = false;
		if (y < 0) {
			negative = true;
			y = -y;
		}
		double result = 1;
		while (y > 0) {
			if ((y & 1) == 1)
				result *= x;
			x = x * x;
			y >>= 1;
		}
		return negative ? 1.0 / result : result;
	}

	public static void main(String[] args) {
		System.out.println(powerIterative(1.5, -2));
		System.out.println(powerIterative(1.0, 1));
		System.out.println(powerIterative(1.1, 1));
		System.out.println(powerIterative(1.0, 2));
		System.out.println(powerIterative(1.1, 2));
		System.out.println(powerIterative(1.1, 3));
		System.out.println(powerIterative(-1.0, 2));
		System.out.println(powerIterative(-1.0, 3));
		System.out.println(powerIterative(3.58, 4));
		System.out.println(powerIterative(-11.32, 5));
		System.out.println(powerIterative(2, -3));
		System.out.println(powerIterative(-3, -3));
		System.out.println(powerIterative(-2.5, -4));
	}

}
