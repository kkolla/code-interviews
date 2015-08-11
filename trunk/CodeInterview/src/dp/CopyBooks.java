package dp;

/**
 * Given an array A of integer with size of n( means n books and number of pages of each book) 
 * and k people to copy the book. 
 * You must distribute the continuous id books to one people to copy. 
 * (You can give book A[1],A[2] to one people, 
 * but you cannot give book A[1], A[3] to one people, 
 * because book A[1] and A[3] is not continuous.) 
 * Each person have can copy one page per minute. 
 * Return the number of smallest minutes need to copy all the books.
 *
 *Example
 *Given array A = [3,2,4], k = 2.
 *Return 5( First person spends 5 minutes to copy book 1 and book 2 and second person spends 4 minutes to copy book 3. )
 *Challenge
 *Could you do this in O(n*k) time ?
 */
public class CopyBooks {

	// t[i][j]: minimum minutes for copying the first j books by i persons
	// answer: t[k][n]
	// t[i][j] = min(max(t[i - 1][m], sum(pages[m + 1]..pages[j]))) where 0 <= m < j
    // http://sidbai.github.io/2015/07/25/Copy-Books/
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
