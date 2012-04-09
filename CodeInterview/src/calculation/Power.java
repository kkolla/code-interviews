package calculation;

public class Power {

	// O(log(y))?
	public static double power(double x, int y) {
		if (y < 0)
			return 1.0 / power(x, -y);
		if (y == 0)
			return 1;
		if (y == 1)
			return x;
		double t = power(x, y / 2);
		double power = t * t;
		if (y % 2 == 1)
			power *= x;
		return power;
	}

	public static void main(String[] args) {
		System.out.println(power(1.0, 1));
		System.out.println(power(1.1, 1));
		System.out.println(power(1.0, 2));
		System.out.println(power(1.1, 2));
		System.out.println(power(1.1, 3));
		System.out.println(power(-1.0, 2));
		System.out.println(power(-1.0, 3));
		System.out.println(power(3.58, 4));
		System.out.println(power(-11.32, 5));
		System.out.println(power(2, -3));
		System.out.println(power(-3, -3));
		System.out.println(power(-2.5, -4));
	}

}
