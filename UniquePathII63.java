public class UniquePathII63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // Create a DP table
        int[][] dp = new int[m][n];

        // Initialize the starting point
        dp[0][0] = (obstacleGrid[0][0] == 0) ? 1 : 0;

        // Fill the first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 0 && dp[i - 1][0] == 1) ? 1 : 0;
        }

        // Fill the first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = (obstacleGrid[0][j] == 0 && dp[0][j - 1] == 1) ? 1 : 0;
        }

        // Fill the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0; // Cell is blocked
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // Sum from top and left
                }
            }
        }

        return dp[m - 1][n - 1]; // Return the value at the bottom-right corner
    }
}

/*
Complexity Analysis:
•	Time Complexity: O(m×n) where mmm is the number of rows and nnn is the number of columns.
•	Space Complexity: O(m×n) for the DP table
*/

