package array;

import utils.CreateUtils;

/*
 * Say you use SVN for source control..you have several revisions of a file...R1, r2, r3..etc..
 * Someone checked in a bug and the revision became bad..need t find the first bad revision..
 * gave a function findBadRevision(int goodRevision, int badRevision) so for e.g the revisions 
 * were GGBB and function passes in 0,3 so the first bad revision is 2. 
 * There exists a function boolean hasBug(int revision) which will tell us if a certain revision 
 * has a bug. can assume good revision < bad revision
 */
public class FindFirstBadRevision {

	public static boolean hasBug(char[] revisions, int i) {
		return revisions[i] == 'B';
	}

	public static int findBadRevision(char[] revisions) {
		int left = 0, right = revisions.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (hasBug(revisions, mid)
					&& (mid == 0 || !hasBug(revisions, mid - 1)))
				return mid;
			else if (hasBug(revisions, mid))
				right = mid - 1;
			else
				left = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int n = CreateUtils.randNonNegInt(20);
		int g = CreateUtils.randNonNegInt(20);
		char[] revisions = new char[n];
		for (int i = 0; i < n; i++)
			revisions[i] = i < g ? 'G' : 'B';
		System.out.println(revisions);
		System.out.println(findBadRevision(revisions));
	}

}
