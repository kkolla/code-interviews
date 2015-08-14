package dp;

/**
 * There are n coins in a line. Two players take turns to take one or two coins from right side until there are no more coins left. The player who take the last coin wins.
 * Could you please decide the first play will win or lose?
 *
 * Example
 * n = 1, return true.
 * n = 2, return true.
 * n = 3, return false.
 * n = 4, return true.
 * n = 5, return true.
 * Challenge
 * O(n) time and O(1) memory
 */
public class CoinsInALine {
	// the first player wins with n coins if he loses with n - 1 or n - 2 coins
    // w[i] = !w[i - 1] || !w[i - 2] = !(w[i - 1] && w[i - 2]) 
    public boolean firstWillWin(int n) {
        if (n <= 2) return n != 0;
        boolean w = false, w1 = true, w2 = true;
        for (int i = 3; i <= n; i++) {
            w = !(w1 && w2);
            w2 = w1;
            w1 = w;
        }
        return w;
    }
}
