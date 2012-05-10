package recursion;

import utils.CreateUtils;
import utils.PrintUtils;

public class FindPathBetweenTwoCellsInMaze {

	// polynomial time complexity?
	public static boolean findPath(int[][] m, int x, int y, int endX, int endY,
			String s) {
		if (x < 0 || x > m.length - 1 || y < 0 || y > m[0].length - 1
				|| m[x][y] == 0 || m[endX][endY] == 0)
			return false;
		m[x][y] = 0;
		s = s == "" ? "(" + x + "," + y + ")" : s + " -> (" + x + "," + y + ")";
		if (x == endX && y == endY) {
			System.out.println(s);
			return true;
		}
		return findPath(m, x - 1, y, endX, endY, s)
				|| findPath(m, x, y - 1, endX, endY, s)
				|| findPath(m, x + 1, y, endX, endY, s)
				|| findPath(m, x, y + 1, endX, endY, s);
	}

	public static void main(String[] args) {
		int[][] m = CreateUtils.randNonNegMatrix(10, 2, false);
		PrintUtils.print2DArray(m);
		int startX = 0, startY = 0, endX = 0, endY = 0;
		while (m[startX][startY] == 0) {
			startX = CreateUtils.randNonNegInt(m.length);
			startY = CreateUtils.randNonNegInt(m[0].length);
		}
		while (m[endX][endY] == 0) {
			endX = CreateUtils.randNonNegInt(m.length);
			endY = CreateUtils.randNonNegInt(m[0].length);
		}
		System.out.println("start: (" + startX + "," + startY + ") end: ("
				+ endX + "," + endY + ")");
		boolean path = findPath(m, startX, startY, endX, endY, "");
		if (!path) {
			System.out.println("no path!");
		}
	}

}
