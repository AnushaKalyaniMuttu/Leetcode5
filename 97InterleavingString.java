public class InterleavingString97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        
        if (m + n != s3.length()) {
            return false; // Lengths must match
        }

        // DP table initialization
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // Both s1 and s2 are empty

        // Fill the first row (using s1)
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // Fill the first column (using s2)
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        // Fill the rest of the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                           (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[m][n]; // The result is in the bottom-right corner
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s1 = "aab";
        String s2 = "axy";
        String s3 = "aaxaby";
        boolean result = sol.isInterleave(s1, s2, s3);
        System.out.println("Is interleaving: " + result); // Output: true
    }
}
/*
Complexity Analysis
•	Time Complexity: O(m×n) where mmm and n are the lengths of s1 and s2respectively.
•	Space Complexity: O(m×n)for the DP table.
*/
