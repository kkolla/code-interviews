package array;

import java.util.Arrays;

public class PlusOne {
	public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = carry + digits[i];
            carry = sum / 10;
            result[i + 1] = sum % 10;
        }

        if (carry == 1) result[0] = 1;
        else result = Arrays.copyOfRange(result, 1, result.length);
        return result;
    }
}
