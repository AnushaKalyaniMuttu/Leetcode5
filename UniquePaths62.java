public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Base cases: Only one way to reach any cell in the first row or first column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
/*Complexity Analysis:
•	Time Complexity: O(m×n) because you are filling up a grid of size m×n times m×n.
•	Space Complexity: O(m×n) due to the 2D array.

*/
