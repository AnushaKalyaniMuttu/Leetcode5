class Solution {

    public int countPyramids(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m][n];
        int ans = 0;

        // bottom-up
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) continue;

                // base height
                dp[i][j] = 1;

                if (i + 1 < m && j - 1 >= 0 && j + 1 < n) {
                    dp[i][j] += Math.min(
                        dp[i + 1][j - 1],
                        Math.min(dp[i + 1][j], dp[i + 1][j + 1])
                    );
                }

                ans += dp[i][j] - 1;
            }
        }

        // same logic for inverted pyramids
        reverse(grid);

        dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) continue;

                dp[i][j] = 1;

                if (i + 1 < m && j - 1 >= 0 && j + 1 < n) {
                    dp[i][j] += Math.min(
                        dp[i + 1][j - 1],
                        Math.min(dp[i + 1][j], dp[i + 1][j + 1])
                    );
                }

                ans += dp[i][j] - 1;
            }
        }

        return ans;
    }

    private void reverse(int[][] grid) {
        int top = 0, bottom = grid.length - 1;
        while (top < bottom) {
            int[] temp = grid[top];
            grid[top] = grid[bottom];
            grid[bottom] = temp;
            top++;
            bottom--;
        }
    }
}
