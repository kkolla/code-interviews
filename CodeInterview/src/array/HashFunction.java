package array;

public class HashFunction {
	
	// (a + b) % p = (a % p + b % p) % p
	// (a - b) % p = (a % p - b % p) % p
	// (a * b) % p = (a % p * b % p) % p
	// a ^ b % p = ((a % p) ^ b) % p 
	public static int hashCode(char[] key,int HASH_SIZE) {
		int hash = 0;
        int base = 1;
        for (int i = key.length - 1; i >= 0; i--) {
        	int num = (int) key[i];
        	hash += (int) ((long) num * base % HASH_SIZE);
        	base = (int) ((long) base * 33 % HASH_SIZE);
        	hash %= HASH_SIZE;
        }
        return hash % HASH_SIZE;
    }

	public static void main(String[] args) {
		char[] key = "ubuntu".toCharArray();
		System.out.println(hashCode(key, 1007));
	}

}
