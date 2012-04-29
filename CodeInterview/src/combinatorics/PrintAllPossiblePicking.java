package combinatorics;

/*
 * Given n sets of choices: (1,2,3), (2,3,4), (4,5)
 * You pick one element from each set of choices.
 * Generate all possible picking.
 */
public class PrintAllPossiblePicking {

	public static void pick(int[][] choices, int start, int[] picking) {
		if (start == choices.length) {
			for (int i = 0; i < picking.length; i++)
				System.out.print(picking[i] + " ");
			System.out.println();
		} else {
			for (int i = 0; i < choices[start].length; i++) {
				picking[start] = choices[start][i];
				pick(choices, start + 1, picking);
			}
		}
	}

	public static void main(String[] args) {
		int[][] choices = { { 1, 2, 3 }, { 2, 3, 4 }, { 4, 5 } };
		pick(choices, 0, new int[choices.length]);
	}

}
