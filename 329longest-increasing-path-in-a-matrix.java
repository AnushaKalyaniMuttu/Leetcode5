public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] cache = new int[rows][cols];
        int maxLength = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxLength = Math.max(maxLength, dfs(matrix, cache, i, j, rows, cols));
            }
        }

        return maxLength;
    }

    private int dfs(int[][] matrix, int[][] cache, int i, int j, int rows, int cols) {
        if (cache[i][j] != 0) return cache[i][j];

        int maxPath = 1;
        int[] dirs = {-1, 0, 1, 0, -1}; // directions: up, right, down, left

        for (int d = 0; d < 4; d++) {
            int ni = i + dirs[d];
            int nj = j + dirs[d + 1];

            if (ni >= 0 && ni < rows && nj >= 0 && nj < cols && matrix[ni][nj] > matrix[i][j]) {
                maxPath = Math.max(maxPath, 1 + dfs(matrix, cache, ni, nj, rows, cols));
            }
        }

        cache[i][j] = maxPath;
        return maxPath;
    }
}
