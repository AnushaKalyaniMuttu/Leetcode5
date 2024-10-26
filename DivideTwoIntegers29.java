public class DivideTwoIntegers29 {

    public int divide(int dividend, int divisor) {
        // Handle edge cases
        if (dividend == 0) return 0;
        if (divisor == 0) return Integer.MAX_VALUE; // Division by zero case
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; // Overflow case
        
        // Determine sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Use long to handle overflow cases
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long quotient = 0;

        // Perform the division using bit manipulation
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor, multiple = 1;

            // Find the largest multiple of divisor that fits in the dividend
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            absDividend -= tempDivisor;
            quotient += multiple;
        }

        // Apply the sign to the result
        return negative ? (int) -quotient : (int) quotient;
    }

    public static void main(String[] args) {
        DivideTwoIntegers solution = new DivideTwoIntegers();
        int dividend = 10;
        int divisor = 3;
        int result = solution.divide(dividend, divisor);
        System.out.println("Result: " + result); // Output: 3
    }
}


?*

Complexity Analysis
•	Time Complexity:
o	O(logN), where N is the absolute value of the dividend. This is because we effectively halve the dividend each time we double the divisor.
•	Space Complexity:
o	O(1). We are using a constant amount of space for variables, independent of the input size.
Summary
This method efficiently divides two integers while handling edge cases and ensuring no overflow occurs, achieving:
•	Time Complexity: O(logN)
•	Space Complexity: O(1)
*/
