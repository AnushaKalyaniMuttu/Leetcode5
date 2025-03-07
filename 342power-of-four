public class Solution {
    public boolean isPowerOfFour(int n) {
        // A power of four must be greater than 0
        if (n <= 0) return false;
        
        // Check if n is a power of 2 (only one bit set)
        // and the bit is in the correct position for powers of 4
        return (n & (n - 1)) == 0 && (n & 0xAAAAAAAA) == 0;
    }
}
