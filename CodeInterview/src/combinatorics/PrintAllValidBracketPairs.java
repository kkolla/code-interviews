package combinatorics;

import utils.CreateUtils;

public class PrintAllValidBracketPairs {

	public static void printAllValidBracketPairs(int left, int right, String s) {
		if (left == 0) {
			for (int i = 0; i < right; i++)
				s += ")";
			System.out.println(s);
			return;
		}
		if (left < right)
			printAllValidBracketPairs(left, right - 1, s + ")");
		printAllValidBracketPairs(left - 1, right, s + "(");
	}

	public static void main(String[] args) {
		int n = CreateUtils.randNonNegInt(10);
		printAllValidBracketPairs(n, n, "");
	}
}
