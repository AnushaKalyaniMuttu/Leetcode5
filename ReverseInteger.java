public class ReverseInteger {
    public int reverse(int x) {
        long reversed = 0;  // Use long to handle overflow

        while (x != 0) {
            // Extract the last digit
            int digit = x % 10;
            x /= 10;

            // Build the reversed number
            reversed = reversed * 10 + digit;

            // Check for overflow
            if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
                return 0;  // Return 0 on overflow
            }
        }

        return (int) reversed;  // Cast back to int
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(123));   // Output: 321
        System.out.println(ri.reverse(-123));  // Output: -321
        System.out.println(ri.reverse(120));   // Output: 21
        System.out.println(ri.reverse(1534236469)); // Output: 0 (overflow)
    }
}
