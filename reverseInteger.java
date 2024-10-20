public class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int digit = x % 10;  // Get the last digit
            x /= 10;  // Remove the last digit

            // Check for overflow before multiplying by 10
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;  // Overflow case for positive numbers
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;  // Overflow case for negative numbers
            }

            result = result * 10 + digit;  // Add the digit to the reversed number
        }
        return result;
    }
}
