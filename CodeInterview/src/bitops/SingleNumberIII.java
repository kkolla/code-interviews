package bitops;

public class SingleNumberIII {
	public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        
        // there must be at least one bit = 1 in xor since two numbers are different
        // find that bit
        int bit = 0;
        for (int i = 0; i < 32; i++)
            if (((xor >> i) & 1) == 1) bit = i;
            
        int a = 0, b = 0;
        for (int num : nums) {
            // split the array by this bit, and find single number in each subarray
            if (((num >> bit) & 1) == 1) a ^= num;
            else b ^= num;
        }
        
        return new int[] {a, b};
    }
}
