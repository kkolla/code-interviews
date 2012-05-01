package dp;

/*
 * Given two words word1 and word2, find the minimum number of steps required to 
 * convert word1 to word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
public class EditDistance {

	// d[i][j]: edit distance for word1.substring(0,i+1) and
	// word2.substring(0,j+1)
	// d[i][j] = d[i-1][j-1] if same character
	// d[i][j] = min(d[i-1][j],d[i][j-1],d[i-1][j-1])+1 otherwise
	// answer: d[word1.length()][word2.length()]

	public static int minDistance(String word1, String word2) {
		return minDistance(word1.toCharArray(), word2.toCharArray());
	}

	public static int minDistance(char[] word1, char[] word2) {
		int[][] d = new int[word1.length + 1][word2.length + 1];
		for (int k = 1; k <= word1.length; k++)
			d[k][0] = k;
		for (int k = 1; k <= word2.length; k++)
			d[0][k] = k;
		for (int i = 1; i <= word1.length; i++) {
			for (int j = 1; j <= word2.length; j++) {
				if (word1[i - 1] == word2[j - 1]) {
					d[i][j] = d[i - 1][j - 1];
				} else {
					d[i][j] = 1 + Math.min(d[i - 1][j - 1],
							Math.min(d[i - 1][j], d[i][j - 1]));
				}
			}
		}
		return d[word1.length][word2.length];
	}

	public static void main(String[] args) {
		System.out.println(minDistance("abc", "bcd"));
	}

}
