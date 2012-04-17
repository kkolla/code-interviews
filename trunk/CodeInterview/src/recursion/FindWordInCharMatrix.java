package recursion;

/*
 * You are given a 2D array of characters and a character pattern. 
 * WAP to find if pattern is present in 2D array. 
 * Pattern can be in any way (all 8 neighbors to be considered) 
 * but you can’t use same character twice while matching. 
 * Return 1 if match is found, 0 if not.
 * e.g. Matrix
 * {'A','C','P','R','C'},
 * {'X','S','O','P','C'},
 * {'V','O','V','N','I'},
 * {'W','G','F','M','N'},
 * {'Q','A','T','I','T'}
 * And pattern is MICROSOFT.
 */
public class FindWordInCharMatrix {

	public static boolean findWord(char[][] m, String query) {
		boolean[][] used = new boolean[m.length][m[0].length];
		return findWord(m, query, used, 0, 0, 0);
	}

	public static boolean findWord(char[][] m, String query, boolean[][] used,
			int x, int y, int start) {
		if (start == query.length())
			return true;
		if (x < 0 || x > m.length - 1 || y < 0 || y > m[0].length - 1)
			return false;
		if (used[x][y])
			return false;
		char c = query.charAt(start);
		if (start == 0 && c != m[x][y]) {
			return findWord(m, query, used, x + 1, y, start)
					|| findWord(m, query, used, x, y + 1, start);
		}
		if (c == m[x][y]) {
			used[x][y] = true;
			boolean found = findWord(m, query, used, x + 1, y, start + 1)
					|| findWord(m, query, used, x, y + 1, start + 1)
					|| findWord(m, query, used, x + 1, y + 1, start + 1)
					|| findWord(m, query, used, x - 1, y, start + 1)
					|| findWord(m, query, used, x, y - 1, start + 1)
					|| findWord(m, query, used, x - 1, y - 1, start + 1)
					|| findWord(m, query, used, x + 1, y - 1, start + 1)
					|| findWord(m, query, used, x - 1, y + 1, start + 1);
			used[x][y] = false;
			return found;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		char[][] m = { { 'A', 'C', 'P', 'R', 'C' },
				{ 'X', 'S', 'O', 'P', 'C' }, { 'V', 'O', 'V', 'N', 'I' },
				{ 'W', 'G', 'F', 'M', 'N' }, { 'Q', 'A', 'T', 'I', 'T' } };
		String[] queries = { "MICROSOFT", "MSFT", "QA", "WOW", "RPC", "FIT",
				"PROP", "CONF" };

		for (String q : queries)
			System.out.println(q + ": " + findWord(m, q));
	}

}
