package calculation;

import java.util.Arrays;

public class CountPrimes {
	public int countPrimes(int n) {
        boolean[] p = new boolean[n];
        Arrays.fill(p, true);
        
        for (int i = 2; i * i < n; i++) {
            if (!p[i]) continue;
            for (int j = i; i * j < n; j++)
                p[i * j] = false;
        }
        
        int count = 0;
        for (int i = 2; i < n; i++)
            if (p[i]) count++;
        return count;
    }
}
