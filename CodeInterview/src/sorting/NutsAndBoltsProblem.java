package sorting;

/**
 * Given a set of n nuts of different sizes and n bolts of different sizes. 
 * There is a one-one mapping between nuts and bolts. 
 * Comparison of a nut to another nut or a bolt to another bolt is not allowed. 
 * It means nut can only be compared with bolt and bolt can only be compared 
 * with nut to see which one is bigger/smaller.
 * We will give you a compare function to compare nut with bolt.
 *
 * Example
 * Given nuts = ['ab','bc','dd','gg'], bolts = ['AB','GG', 'DD', 'BC'].

 * Your code should find the matching bolts and nuts.

 * one of the possible return:

 * nuts = ['ab','bc','dd','gg'], bolts = ['AB','BC','DD','GG'].

 * we will tell you the match compare function. If we give you another compare function.

 * the possible return is the following:

 * nuts = ['ab','bc','dd','gg'], bolts = ['BC','AA','DD','GG'].

 * So you must use the compare function that we give to do the sorting.

 * The order of the nuts or bolts does not matter. 
 * You just need to find the matching bolt for each nut.
 */
public class NutsAndBoltsProblem {
	public class NBComparator {
		public int cmp(String a, String b) {
			return 0; // fake
		}
	}
	
	// http://algorithm.yuanbin.me/problem_misc/nuts_and_bolts_problem.html
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
    	assert(nuts.length == bolts.length);
    	qsort(nuts, bolts, 0, nuts.length - 1, compare);
    }
    
    private void qsort(String[] nuts, String[] bolts, int l, int r, NBComparator compare) {
    	if (l >= r) return;
    	// partition nuts based on bolts[l]
    	int partitionPosition = partition(nuts, bolts[l], l, r, compare);
    	// partition bolts based on nuts[partitionPosition]
    	partition(bolts, nuts[partitionPosition], l, r, compare);
    	// now nuts[partitionPosition] and bolts[partitionPosition] are in right position
    	qsort(nuts, bolts, l, partitionPosition - 1, compare);
    	qsort(nuts, bolts, partitionPosition + 1, r, compare);
    }
	
	private int partition(String[] target, String pivot, int l, int r, NBComparator compare) {
		int m = l;
		for (int i = l + 1; i <= r; i++) {
			int result1 = compare.cmp(target[i], pivot);
			int result2 = compare.cmp(pivot, target[i]);
			if (result1 == -1 || result2 == 1) {
				m++;
				swap(target, i, m);
			} else if (result1 == 0 || result2 == 0) {
				swap(target, i, l);
				i--;
			}
			
		}
		
		// move pivot to proper index
        swap(target, m, l);
        
        return m;
	}
	
	private void swap(String[] target, int l, int r) {
        String temp = target[l];
        target[l] = target[r];
        target[r] = temp;
    }

	// O(n^2)
	public void sortNutsAndBoltsNaive(String[] nuts, String[] bolts, NBComparator compare) {
        for (int i = 0; i < nuts.length; i++) 
            for (int j = 0; j < bolts.length; j++) {
                if (compare.cmp(nuts[i], bolts[j]) == 0) {
                    String temp = bolts[j];
                    bolts[j] = bolts[i];
                    bolts[i] = temp;
                    break;
                }
            }
    }
}
