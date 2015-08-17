package combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationIndex {
	
	// O(n^2), O(n)
	public static long permutationIndex(int[] A) {
		int[] B = Arrays.copyOf(A, A.length);
        Arrays.sort(B);
        
        List<Integer> sortedNumbers = new ArrayList<Integer>();
        for (int i = 0; i < B.length; i++) {
        	sortedNumbers.add(B[i]);
        }
        
        long[] factorials = new long[A.length + 1];
        factorials[0] = 1;
		for (int i = 1; i < factorials.length; i++)
			factorials[i] = i * factorials[i - 1];

		long index = 1;
		for (int i = 0; i < A.length; i++) {
			int numIndex = sortedNumbers.indexOf(A[i]);
			index += numIndex * factorials[A.length - i - 1];
			sortedNumbers.remove(numIndex);
		}
		
		return index;
    }
	
	// O(n^2), O(1)
	// http://www.geekviewpoint.com/java/numbers/permutation_index
	// http://algorithm.yuanbin.me/exhaustive_search/permutation_index.html

	public static void main(String[] args) {
		int[] A = { 1, 3, 4, 6, 5};
		System.out.println(permutationIndex(A));
	}

}
