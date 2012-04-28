package string;

public class GroupStringsBySameAnagram {

	// O(n^2), assuming the length of string array and the length of each string
	// are both n
	public static void group(String[] ss) {
		int n = ss.length;
		// for each string, construct a hash table for character counters
		// O(n^2)
		int[][] counts = new int[n][256];
		for (int i = 0; i < n; i++) {
			String s = ss[i];
			for (int j = 0; j < s.length(); j++)
				counts[i][s.charAt(j) - Character.MIN_VALUE]++;

		}
		boolean[] output = new boolean[n];
		// compare each hash tables pair
		// O(256*n*n)=O(n^2)
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++)
				for (int k = 0; k < 256; k++)
					if (counts[i][k] != counts[j][k])
						break;
					else if (k == 255 && !output[j]) {
						if (!output[i]) {
							output[i] = true;
							System.out.println(ss[i]);
						}
						output[j] = true;
						System.out.println(ss[j]);
					}
		}

	}

	public static void main(String[] args) {
		String[] ss = { "abc", "albert", "cat", "gate", "cab", "grow", "teag",
				"bca", "atc", "act" };
		group(ss);
	}

}
