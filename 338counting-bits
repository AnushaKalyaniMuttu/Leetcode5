public class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            // The number of 1's in i is the same as the number of 1's in i / 2, 
            // plus 1 if i is odd (i & 1) or 0 if i is even.
            result[i] = result[i >> 1] + (i & 1);
        }
        
        return result;
    }
}
