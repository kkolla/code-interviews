package array;

import java.util.Arrays;

/**
 * Given n pieces of wood with length L[i] (integer array). 
 * Cut them into small pieces to guarantee you could have equal or 
 * more than k pieces with the same length. 
 * What is the longest length you can get from the n pieces of wood? 
 * Given L & k, return the maximum length of the small pieces.
 * Example
 * For L=[232, 124, 456], k=7, return 114.
 * 
 * Note
 * You couldn't cut wood into float length.
 * 
 * Challenge
 * O(n log Len), where Len is the longest length of the wood.
 *
 */
public class WoodCut {
	public int woodCut(int[] L, int k) {
        if (L.length == 0) return 0;
        
        int maxLen = 0;
        Arrays.sort(L);
        int l = 1, r = L[L.length - 1]; // search for length in [1, max length piece]
        while (l <= r) {
            int len = l + (r - l) / 2;
            int pieces = 0; // how many pieces we can get in total
            for (int ll : L) pieces += ll / len;
            if (pieces < k) {
                // requirement not satisfied yet
                // so we need to cut smaller pieces by decreasing len
                r = len - 1;
            } else {
                // requirement satisfied but may not be the optimal
                // save result as the potential answer and increasing len
                maxLen = len;
                l = len + 1;
            }
        }
        return maxLen;
    }
}
