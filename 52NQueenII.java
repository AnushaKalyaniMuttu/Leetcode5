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



/*
Explanation of the Code
1.	Data Structures:
o	columns: A boolean array to track which columns have queens placed.
o	diag1: A boolean array to track the major diagonals (from top-left to bottom-right).
o	diag2: A boolean array to track the minor diagonals (from top-right to bottom-left).
2.	Backtracking:
o	The method backtrack(int row, int n, boolean[] columns, boolean[] diag1, boolean[] diag2) is called recursively.
o	If row equals n, it means we've successfully placed queens in all rows, and we increment the count.
o	For each column in the current row, we check if we can place a queen (not attacked by any other queens) and mark the column and diagonals as occupied.
o	After placing a queen, we recursively call backtrack for the next row.
o	If a placement does not lead to a solution, we backtrack by removing the queen and unmarking the column and diagonals.
Time and Space Complexity
1.	Time Complexity:
o	The time complexity is O(N!) in the worst case because we are trying to place a queen in every row and there are N choices per row. However, many configurations are pruned due to the checks on columns and diagonals.
2.	Space Complexity:
o	The space complexity is O(N) due to the storage used for the column and diagonal tracking arrays.
Example Outputs
•	For n=4, the output will be 2, as there are two distinct solutions.
•	For n=1, the output will be 1, as there is one solution with a single queen on the board

*/
