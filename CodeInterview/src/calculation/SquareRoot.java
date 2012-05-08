package calculation;

public class SquareRoot {

	// O(log(n))?
	public static double sqrt(double number) {
		if (number < 0)
			return Double.NaN;
		double low = 0;
		double high = number > 1 ? number : 1;
		double eps = 0.000000001;
		int loops = 1000;
		double sqrt = 0;
		while (loops-- > 0) {
			sqrt = (low + high) / 2;
			if (Math.abs(sqrt * sqrt - number) <= eps)
				break;
			else if (sqrt * sqrt > number)
				high = sqrt;
			else
				low = sqrt;
		}
		return sqrt;
	}

	public static void main(String[] args) {
		double[] tests = { 1.0, 1.2, 0.2, 0.25, 0.36, 0.37, 15, 16, 25,
				25.5553232341, 100, 101 };
		for (int i = 0; i < tests.length; i++)
			System.out.println("sqrt(" + tests[i] + "): " + sqrt(tests[i]));
	}

}
