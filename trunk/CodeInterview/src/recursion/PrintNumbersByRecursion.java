package recursion;

import java.util.ArrayList;
import java.util.List;

import utils.PrintUtils;

public class PrintNumbersByRecursion {
	public static  List<Integer> numbersByRecursion(int n) {
		List<Integer> result = new ArrayList<Integer>();
		result.add(0);
        numbersByRecursion(n, result);
        return result.subList(1, result.size());
    }

	private static void numbersByRecursion(int n, List<Integer> result) {
		if (n == 0) return;
		numbersByRecursion(n - 1, result);
		int powerOfTen = (int) Math.pow(10, n - 1);
		int prevSize = result.size();
		for (int i = powerOfTen; i <= 9 * powerOfTen; i += powerOfTen) {
			for (int j = 0; j < prevSize; j++) {
				result.add(i + result.get(j));
			}
		}
	}
	
	public static void main(String[] s) {
		PrintUtils.printList(numbersByRecursion(2));
	}
}
