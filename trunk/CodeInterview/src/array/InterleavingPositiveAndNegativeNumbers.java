package array;

public class InterleavingPositiveAndNegativeNumbers {
	public void rerange(int[] A) {     
        int numPositives = 0;
        for (int a : A)
            if (a > 0) numPositives++;
            
        boolean positiveExpected = numPositives * 2 > A.length;
        int i = 0, positivePos = 0, negativePos = 0; // always >= i
        while(positivePos < A.length && negativePos < A.length) {
            // find the next positive
            while (positivePos < A.length && A[positivePos] < 0) positivePos++;
            // find the next negative
            while (negativePos < A.length && A[negativePos] > 0) negativePos++;
            
            if (positiveExpected) {
                swap(A, i, positivePos);
                if (i == positivePos) positivePos++;
            } else {
                swap(A, i, negativePos);
                if (i == negativePos) negativePos++;
            }
            
            positiveExpected = !positiveExpected;
            i++;
        }
   }
   
   private void swap(int[] A, int i, int j) {
       int t = A[i];
       A[i] = A[j];
       A[j] = t;
   }
}
