package bitops;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 * Follow up:
 * If this function is called many times, how would you optimize it?
 *
 */
public class ReverseBits {
	
	
	public static int reverseBits(int n) {
        int t = 0;
        for (int i = 0; i < 32; i++) {
            t |= (n >> i) & 1;
            if (i != 31) t <<= 1;
        }
        return t;
    }
	
	public static int reverseBitsByXOR(int n) {
		for (int i = 0; i < 16; i++)
			n = swapBits(n, i, 32 - i -1);
		return n;
	}
	
	private static int swapBits(int n, int i, int j) {
		int firstBit = (n >> i) & 1;
		int secondBit = (n >> j) & 1;
		return (firstBit ^ secondBit) == 0 ? n : n ^ ((1 << i) | (1 << j)); // toggle two bits if different
	}
	
	// more solutions: http://articles.leetcode.com/2011/08/reverse-bits.html

	public static void main(String[] args) {
		System.out.println(reverseBits(43261596));
		System.out.println(reverseBitsByXOR(43261596));
	}

}
