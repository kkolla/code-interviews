package calculation;

public class FastPower {
	// a ^ n % b = (a ^ (n - 1) * a) % b = (a ^ (n - 1) % b * (a % b)) % b
    public int fastPower(int a, int b, int n) {
        if (n == 1) return a % b;
        if (n == 0) return 1 % b;
        
        int half = fastPower(a, b, n / 2);
        long t = (long) (half % b) * (half % b) % b;
        if (n % 2 == 0) {
            return (int) t;
        } else {
            return (int) (t * a % b);
        }
    }
}
