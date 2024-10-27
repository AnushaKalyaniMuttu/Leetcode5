public class NQueens {
    private int count = 0;

    public int totalNQueens(int n) {
        boolean[] columns = new boolean[n]; // Column tracking
        boolean[] diag1 = new boolean[2 * n]; // Major diagonal tracking
        boolean[] diag2 = new boolean[2 * n]; // Minor diagonal tracking
        backtrack(0, n, columns, diag1, diag2);
        return count;
    }

    private void backtrack(int row, int n, boolean[] columns, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            count++; // Found a valid configuration
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!columns[col] && !diag1[row + col] && !diag2[row - col + n]) {
                // Place the queen
                columns[col] = true;
                diag1[row + col] = true;
                diag2[row - col + n] = true;

                // Recur for the next row
                backtrack(row + 1, n, columns, diag1, diag2);

                // Remove the queen (backtrack)
                columns[col] = false;
                diag1[row + col] = false;
                diag2[row - col + n] = false;
            }
        }
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        int n = 4; // Example input
        int result = nQueens.totalNQueens(n);
        System.out.println("Number of distinct solutions for N = " + n + ": " + result);
    }
}
