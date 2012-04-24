package calculation;

import utils.CreateUtils;

public class GetMaxWithoutComparison {

	public static int max(int a, int b) {
		int k = (a - b) >> 31; // potential overflow
		return a + k * (a - b);
	}

	public static void main(String[] args) {
		int a = CreateUtils.randInt(100);
		int b = CreateUtils.randInt(100);
		System.out.println("min(" + a + "," + b + ")=" + max(a, b));
	}

}
