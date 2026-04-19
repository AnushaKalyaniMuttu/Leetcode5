import java.lang.Math;

public class Solution {

    public int divide(int dividend, int divisor) {

        // Edge cases
        if (dividend == 0) return 0;
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        // Determine sign
        boolean negative = (dividend < 0) ^ (divisor < 0);

        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        long quotient = 0;

        while (absDividend >= absDivisor) {
            long temp = absDivisor;
            long multiple = 1;

            while (absDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            absDividend -= temp;
            quotient += multiple;
        }

        return negative ? (int) -quotient : (int) quotient;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int dividend = 10;
        int divisor = 3;

        System.out.println(solution.divide(dividend, divisor)); // Output: 3
    }
}
