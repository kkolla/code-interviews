package array;

import java.util.Arrays;

/**
 * Given an array of integers, how many three numbers can be found in the array, 
 * so that we can build an triangle whose three edges length is the three numbers that we find?
 * Example
 * Given array S = [3,4,6,7], return 3. They are:
 * [3,4,6]
 * [3,6,7]
 * [4,6,7]
 * Given array S = [4,4,4,4], return 4. They are:
 * [4(1),4(2),4(3)]
 * [4(1),4(2),4(4)]
 * [4(1),4(3),4(4)]
 * [4(2),4(3),4(4)]
 */
public class TriangleCount {
	
	public int triangleCount(int S[]) {
		if (S.length < 3) return 0;
		Arrays.sort(S);
		int count = 0;
		for (int end = S.length - 1; end > 1; end--) {
			int start = 0, mid = end - 1;
			// trying to form triangles using A[start], A[end] and another
			while (start < mid) {
				if (S[start] + S[mid] <= S[end]) {
				    // invalid triangle
					// need to have a longer edge - increasing start is the only choice
					start++;
				} else {
					count += mid - start; // all the elements from (start, mid] can be used as edge
					// see if a shorter edge works
					mid--;
				}
			}
		}
		return count;
	}

	public int triangleCountNaive(int S[]) {
        if (S.length < 3) return 0;
        int count = 0;
        for (int i = 0; i < S.length - 2; i++)
            for (int j = i + 1; j < S.length - 1; j++)
                for (int k = j + 1; k < S.length; k++)
                    if (canFormTriangle(S[i], S[j], S[k])) count++;
        return count;
    }
    
    private boolean canFormTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }
}
