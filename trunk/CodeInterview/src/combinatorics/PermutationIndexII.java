package combinatorics;

import java.util.HashMap;
import java.util.Map;

public class PermutationIndexII {
	public long permutationIndexII(int[] A) {
        long index = 1;
        long factorial = 1;
        
        long[] factorials = new long[A.length + 1];
        factorials[0] = 1;
		for (int i = 1; i < factorials.length; i++)
			factorials[i] = i * factorials[i - 1];
        
        for (int i = A.length - 1; i >= 0; i--) {
            Map<Integer, Integer> numToCount = new HashMap<Integer, Integer>();
            numToCount.put(A[i], 1);
            int rank = 0;
            
            for (int j = i + 1; j < A.length; j++) {
                int count = numToCount.containsKey(A[j]) ? numToCount.get(A[j]) : 0;
                numToCount.put(A[j], count + 1);
                
                if (A[i] > A[j]) rank++;
            }
            //System.out.println("i = " + i + ", rank = " + rank + ", factorial = " + factorial + " duplicates = " + numDuplicatePermutations(numToCount, factorials));
            index += rank * factorial / numDuplicatePermutations(numToCount, factorials); // high school math..
            factorial *= A.length - i;
        }
        
        return index;
    }
    
    private long numDuplicatePermutations(Map<Integer, Integer> numToCount, long[] factorials) {
        long num = 1;
        for (int count : numToCount.values()) {
            num *= factorials[count];    
        }
        return num;
    }
}
