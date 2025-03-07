public class Solution {
    public int integerBreak(int n) {
        if (n <= 3) return n - 1; // Base cases for small n

        int product = 1;
        while (n > 4) {
            product *= 3; // Use as many 3's as possible for maximum product
            n -= 3;
        }
        return product * n; // Multiply the remaining part
    }
}
